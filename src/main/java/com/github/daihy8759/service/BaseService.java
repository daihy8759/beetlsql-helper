package com.github.daihy8759.service;

import com.github.daihy8759.context.ContextHandler;
import com.github.daihy8759.model.ModelBase;
import java.util.Date;
import java.util.List;
import org.beetl.sql.mapper.BaseMapper;

/**
 * @author daihy
 */
public class BaseService<T extends ModelBase<I>, I> {

  private final BaseMapper<T> baseMapper;

  protected BaseService(BaseMapper<T> baseMapper) {
    this.baseMapper = baseMapper;
  }

  protected void prePersist(T clazz) {
    if (clazz.getCreateUser() == null) {
      clazz.setCreateUser((I) ContextHandler.getUserId());
    }
    clazz.setCreateTime(new Date());
  }

  protected void preUpdate(T clazz) {
    clazz.setUpdateUser((I) ContextHandler.getUserId());
    clazz.setUpdateTime(new Date());
  }

  public T single(I id) {
    return baseMapper.single(id);
  }

  public T unique(I id) {
    return baseMapper.unique(id);
  }

  public List<T> all() {
    return baseMapper.all();
  }

  public void save(T model) {
    model.setCreateTime(new Date());
    baseMapper.insertTemplate(model);
  }

  public void insertBatch(List<T> list) {
    for (T t : list) {
      prePersist(t);
    }
    insertBatch(list);
  }

  public void update(T model) {
    model.setUpdateTime(new Date());
    baseMapper.updateById(model);
  }

  public void deleteById(I id) {
    baseMapper.deleteById(id);
  }
}

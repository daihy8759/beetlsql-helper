package com.github.daihy8759.service;

import cn.hutool.core.lang.Assert;
import com.github.daihy8759.exception.PrimaryKeyNotFoundException;
import com.github.daihy8759.model.CurrentUser;
import com.github.daihy8759.model.ModelBase;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.mapper.BaseMapper;

/**
 * @author daihy
 */
public class BaseService<T extends ModelBase<I>, I> {

  protected final BaseMapper<T> baseMapper;
  private Class<T> clazz;

  protected BaseService(BaseMapper<T> baseMapper) {
    this.baseMapper = baseMapper;
    Object obj = this.getClass().getGenericSuperclass();
    if (obj instanceof ParameterizedType) {
      ParameterizedType type = (ParameterizedType) obj;
      clazz = (Class<T>) type.getActualTypeArguments()[0];
    } else {
      clazz = (Class<T>) obj;
    }
  }

  private String getPrimaryKey() {
    SQLManager sm = baseMapper.getSQLManager();
    List<String> idCols = sm.getClassDesc(clazz).getIdCols();
    if (idCols.isEmpty()) {
      throw new PrimaryKeyNotFoundException("主键不存在!");
    }
    if (idCols.size() > 1) {
      throw new RuntimeException("暂不支持复合主键的查询！");
    }
    return idCols.get(0);
  }

  protected void prePersist(T clazz, CurrentUser<I> currentUser) {
    clazz.setCreateUser(currentUser.getUserId());
    clazz.setCreateTime(new Date());
  }

  protected void preUpdate(T clazz, CurrentUser<I> currentUser) {
    clazz.setUpdateUser(currentUser.getUserId());
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

  public void insert(T model, CurrentUser<I> currentUser) {
    prePersist(model, currentUser);
    baseMapper.insertTemplate(model);
  }

  public void insertBatch(List<T> list, CurrentUser<I> currentUser) {
    for (T t : list) {
      prePersist(t, currentUser);
    }
    baseMapper.insertBatch(list);
  }

  public int update(T model, CurrentUser<I> currentUser) {
    preUpdate(model, currentUser);
    return baseMapper.updateById(model);
  }

  public int deleteById(I id) {
    Assert.notNull(id, "主键不能为空!");
    return baseMapper.deleteById(id);
  }

  public int delete(I[] ids) {
    if (ids == null || ids.length == 0) {
      return 0;
    }
    return baseMapper.createLambdaQuery().andIn(getPrimaryKey(), Arrays.asList(ids)).delete();
  }

}

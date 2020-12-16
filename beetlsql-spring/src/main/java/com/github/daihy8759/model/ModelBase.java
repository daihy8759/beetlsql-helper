package com.github.daihy8759.model;

import java.util.Date;
import org.beetl.sql.annotation.entity.InsertIgnore;
import org.beetl.sql.annotation.entity.UpdateIgnore;
import org.beetl.sql.annotation.entity.Version;

/**
 * @author daihy
 */
public class ModelBase<T> implements java.io.Serializable {

  private static final long serialVersionUID = -4443851546183503891L;

  private T id;

  @UpdateIgnore
  private T createUser;

  @UpdateIgnore
  private Date createTime;

  @InsertIgnore
  private T updateUser;

  @InsertIgnore
  private Date updateTime;

  @Version
  private Long recordVersion;

  public T getId() {
    return id;
  }

  public void setId(T id) {
    this.id = id;
  }

  public T getCreateUser() {
    return createUser;
  }

  public void setCreateUser(T createUser) {
    this.createUser = createUser;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public T getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(T updateUser) {
    this.updateUser = updateUser;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public Long getRecordVersion() {
    return recordVersion;
  }

  public void setRecordVersion(Long recordVersion) {
    this.recordVersion = recordVersion;
  }
}

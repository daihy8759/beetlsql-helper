package com.github.daihy8759.model;

public class CurrentUser<T> {

  private T userId;

  public T getUserId() {
    return userId;
  }

  public void setUserId(T userId) {
    this.userId = userId;
  }
}

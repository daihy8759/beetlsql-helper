package com.github.daihy8759.exception;

public class PrimaryKeyNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -8126916675305637042L;

  public PrimaryKeyNotFoundException(String message) {
    super(message);
  }

}

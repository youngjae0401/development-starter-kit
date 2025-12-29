package com.starter.app.common.exception;

import com.starter.app.common.response.ErrorCode;

public class EntityNotFoundException extends BusinessException {

  public EntityNotFoundException(String message) {
    super(ErrorCode.ENTITY_NOT_FOUND, message);
  }

  public EntityNotFoundException() {
    super(ErrorCode.ENTITY_NOT_FOUND);
  }
}

package com.starter.app.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

  // Common
  INVALID_INPUT_VALUE("C001", "Invalid input value"),
  METHOD_NOT_ALLOWED("C002", "Method not allowed"),
  INTERNAL_SERVER_ERROR("C003", "Internal server error"),
  INVALID_TYPE_VALUE("C004", "Invalid type value"),
  HANDLE_ACCESS_DENIED("C005", "Access denied"),
  RESOURCE_NOT_FOUND("C006", "Resource not found"),

  // Business
  ENTITY_NOT_FOUND("B001", "Entity not found"),
  DUPLICATE_RESOURCE("B002", "Duplicate resource"),

  // User
  USER_NOT_FOUND("U001", "User not found"),
  DUPLICATE_EMAIL("U002", "Duplicate email"),

  // Authentication
  UNAUTHORIZED("A001", "Unauthorized"),
  AUTHENTICATION_FAILED("A002", "Authentication failed"),
  TOKEN_EXPIRED("A003", "Token expired"),
  INVALID_TOKEN("A004", "Invalid token");

  private final String code;
  private final String message;
}

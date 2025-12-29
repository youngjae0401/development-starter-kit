package com.starter.app.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

  private final boolean success;
  private final String message;
  private final T data;
  private final ErrorInfo error;

  public static <T> ApiResponse<T> success(T data) {
    return new ApiResponse<>(true, "Success", data, null);
  }

  public static <T> ApiResponse<T> success(String message, T data) {
    return new ApiResponse<>(true, message, data, null);
  }

  public static <T> ApiResponse<T> error(ErrorCode errorCode) {
    return new ApiResponse<>(false, errorCode.getMessage(), null, new ErrorInfo(errorCode.getCode(), errorCode.getMessage()));
  }

  public static <T> ApiResponse<T> error(ErrorCode errorCode, String customMessage) {
    return new ApiResponse<>(false, customMessage, null, new ErrorInfo(errorCode.getCode(), customMessage));
  }

  @Getter
  @AllArgsConstructor
  public static class ErrorInfo {

    private final String code;
    private final String message;
  }
}

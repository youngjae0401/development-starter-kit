package com.starter.app.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

public class UserDto {

  public static class Request {

    @Schema(description = "User creation request")
    public record Create(
        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email format")
        @Schema(description = "User email", example = "user@example.com")
        String email,

        @NotBlank(message = "Name is required")
        @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
        @Schema(description = "User name", example = "John Doe")
        String name,

        @NotBlank(message = "Password is required")
        @Size(min = 8, message = "Password must be at least 8 characters")
        @Schema(description = "User password", example = "password123")
        String password
    ) {

    }

    @Data
    @Schema(description = "User search request")
    public static class Search {

      @Schema(description = "Search keyword", example = "john")
      private String keyword;

      @Schema(description = "Page number (0-based)", example = "0", defaultValue = "0")
      private int page = 0;

      @Schema(description = "Page size", example = "20", defaultValue = "20")
      private int size = 20;

      @Schema(description = "Sort by field", example = "createdAt", defaultValue = "createdAt")
      private String sortBy = "createdAt";

      @Schema(description = "Sort direction (ASC/DESC)", example = "DESC", defaultValue = "DESC")
      private String direction = "DESC";
    }
  }

  public static class Response {

    @Schema(description = "User basic information")
    public record Info(
        @Schema(description = "User ID", example = "1")
        Long id,

        @Schema(description = "User email", example = "user@example.com")
        String email,

        @Schema(description = "User name", example = "John Doe")
        String name,

        @Schema(description = "User status", example = "ACTIVE")
        String status,

        @Schema(description = "Created timestamp")
        LocalDateTime createdAt,

        @Schema(description = "Updated timestamp")
        LocalDateTime updatedAt
    ) {

    }
  }
}

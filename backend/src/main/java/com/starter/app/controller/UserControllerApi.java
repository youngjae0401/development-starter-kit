package com.starter.app.controller;

import com.starter.app.common.response.ApiResponse;
import com.starter.app.common.response.PageResponse;
import com.starter.app.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "User", description = "User API")
public interface UserControllerApi {

  @Operation(summary = "Get user by ID", description = "Returns a single user")
  ApiResponse<UserDto.Response.Info> getUser(
      @Parameter(description = "User ID", required = true)
      @PathVariable Long id
  );

  @Operation(summary = "Search users", description = "Search users with pagination")
  ApiResponse<PageResponse<UserDto.Response.Info>> searchUsers(
      @ModelAttribute UserDto.Request.Search searchRequest
  );

  @Operation(summary = "Create user", description = "Create a new user")
  ApiResponse<UserDto.Response.Info> createUser(
      @Valid @RequestBody UserDto.Request.Create request
  );
}

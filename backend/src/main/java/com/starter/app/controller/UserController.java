package com.starter.app.controller;

import com.starter.app.common.response.ApiResponse;
import com.starter.app.common.response.PageResponse;
import com.starter.app.common.util.PageUtil;
import com.starter.app.dto.UserDto;
import com.starter.app.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController implements UserControllerApi {

  private final UserService userService;

  @Override
  @GetMapping("/{id}")
  public ApiResponse<UserDto.Response.Info> getUser(@PathVariable Long id) {
    return ApiResponse.success(userService.getUser(id));
  }

  @Override
  @GetMapping
  public ApiResponse<PageResponse<UserDto.Response.Info>> searchUsers(
      @ModelAttribute UserDto.Request.Search searchRequest
  ) {
    Pageable pageable = PageUtil.createPageable(
        searchRequest.getPage(),
        searchRequest.getSize(),
        searchRequest.getSortBy(),
        searchRequest.getDirection()
    );
    Page<UserDto.Response.Info> users = userService.searchUsers(searchRequest.getKeyword(), pageable);

    return ApiResponse.success(PageResponse.of(users));
  }

  @Override
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ApiResponse<UserDto.Response.Info> createUser(@Valid @RequestBody UserDto.Request.Create request) {
    return ApiResponse.success("User created successfully", userService.createUser(request));
  }
}

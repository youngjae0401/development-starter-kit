package com.starter.app.service;

import com.starter.app.common.exception.EntityNotFoundException;
import com.starter.app.domain.User;
import com.starter.app.dto.UserDto;
import com.starter.app.mapper.UserEntityMapper;
import com.starter.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

  private final UserRepository userRepository;
  private final UserEntityMapper userEntityMapper;

  public UserDto.Response.Info getUser(Long id) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    return userEntityMapper.toResponse(user);
  }

  public Page<UserDto.Response.Info> searchUsers(String keyword, Pageable pageable) {
    return userRepository.searchUsers(keyword, pageable)
        .map(userEntityMapper::toResponse);
  }

  @Transactional
  public UserDto.Response.Info createUser(UserDto.Request.Create request) {
    User user = userEntityMapper.toEntity(request);
    User savedUser = userRepository.save(user);
    return userEntityMapper.toResponse(savedUser);
  }
}

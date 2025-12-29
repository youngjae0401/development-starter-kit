package com.starter.app.repository;

import com.starter.app.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRepositoryCustom {

  Page<User> searchUsers(String keyword, Pageable pageable);
}

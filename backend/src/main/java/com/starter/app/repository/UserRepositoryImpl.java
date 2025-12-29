package com.starter.app.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.starter.app.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.starter.app.domain.QUser.user;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {

  private final JPAQueryFactory queryFactory;

  @Override
  public Page<User> searchUsers(String keyword, Pageable pageable) {
    List<User> content = queryFactory
        .selectFrom(user)
        .where(searchKeyword(keyword))
        .offset(pageable.getOffset())
        .limit(pageable.getPageSize())
        .fetch();

    JPAQuery<Long> countQuery = queryFactory
        .select(user.count())
        .from(user)
        .where(searchKeyword(keyword));

    return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchOne);
  }

  private BooleanExpression searchKeyword(String keyword) {
    if (!StringUtils.hasText(keyword)) {
      return null;
    }

    return user.name.contains(keyword)
        .or(user.email.contains(keyword));
  }
}

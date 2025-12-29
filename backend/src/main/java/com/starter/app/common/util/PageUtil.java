package com.starter.app.common.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageUtil {

  private static final int DEFAULT_PAGE_SIZE = 20;
  private static final int MAX_PAGE_SIZE = 100;

  public static Pageable createPageable(int page, int size) {
    return PageRequest.of(
        Math.max(0, page),
        validateSize(size)
    );
  }

  public static Pageable createPageable(int page, int size, Sort sort) {
    return PageRequest.of(
        Math.max(0, page),
        validateSize(size),
        sort
    );
  }

  public static Pageable createPageable(int page, int size, String sortBy, String direction) {
    Sort sort = createSort(sortBy, direction);
    return createPageable(page, size, sort);
  }

  public static Sort createSort(String property, String direction) {
    if (property == null || property.isBlank()) {
      return Sort.unsorted();
    }

    Sort.Direction sortDirection = Sort.Direction.fromOptionalString(direction)
        .orElse(Sort.Direction.DESC);

    return Sort.by(sortDirection, property);
  }

  private static int validateSize(int size) {
    if (size <= 0) {
      return DEFAULT_PAGE_SIZE;
    }

    return Math.min(size, MAX_PAGE_SIZE);
  }
}

package com.starter.app.common.response;

import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
public class PageResponse<T> {

  private final List<T> content;
  private final PageInfo pageInfo;

  public PageResponse(Page<T> page) {
    this.content = page.getContent();
    this.pageInfo = new PageInfo(
        page.getNumber(),
        page.getSize(),
        page.getTotalElements(),
        page.getTotalPages(),
        page.isFirst(),
        page.isLast()
    );
  }

  @Getter
  public static class PageInfo {

    private final int currentPage;
    private final int pageSize;
    private final long totalElements;
    private final int totalPages;
    private final boolean first;
    private final boolean last;

    public PageInfo(
        int currentPage,
        int pageSize,
        long totalElements,
        int totalPages,
        boolean first,
        boolean last
    ) {
      this.currentPage = currentPage;
      this.pageSize = pageSize;
      this.totalElements = totalElements;
      this.totalPages = totalPages;
      this.first = first;
      this.last = last;
    }
  }

  public static <T> PageResponse<T> of(Page<T> page) {
    return new PageResponse<>(page);
  }
}

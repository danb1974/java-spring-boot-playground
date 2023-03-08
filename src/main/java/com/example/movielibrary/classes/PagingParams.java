package com.example.movielibrary.classes;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PagingParams {
    private final int page;

    private final int limit;

    public PagingParams(int page, int limit) {
        this.page = page;
        this.limit = limit;
    }

    public int getPage() {
        return page;
    }

    public int getLimit() {
        return limit;
    }

    public Pageable getPageable() {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        return getPageable(sort);
    }

    public Pageable getPageable(Sort sort) {
        return PageRequest.of(page - 1, limit, sort);
    }
}

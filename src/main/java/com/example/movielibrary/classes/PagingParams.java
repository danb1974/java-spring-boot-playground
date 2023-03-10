package com.example.movielibrary.classes;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public record PagingParams(int page, int limit) {
    public Pageable getPageable() {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        return getPageable(sort);
    }

    public Pageable getPageable(Sort sort) {
        return PageRequest.of(page - 1, limit, sort);
    }
}

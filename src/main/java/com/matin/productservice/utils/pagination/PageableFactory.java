package com.matin.productservice.utils.pagination;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class PageableFactory {

    private static final int DEFAULT_PAGE = 0;
    private static final int DEFAULT_SIZE = 20;
    private static final String DEFAULT_SORT_FIELD = "id";
    private static final Sort.Direction DEFAULT_SORT_DIRECTION = Sort.Direction.ASC;

    public static Pageable createPageable(int page) {
        return createPageable(page, DEFAULT_SIZE, DEFAULT_SORT_FIELD, DEFAULT_SORT_DIRECTION);
    }

    public static Pageable createPageable(int page, int size) {
        return createPageable(page, size, DEFAULT_SORT_FIELD, DEFAULT_SORT_DIRECTION);
    }

    public static Pageable createPageable(int page, int size, String sortField, Sort.Direction sortDirection) {
        Sort sort = Sort.by(sortDirection, sortField);
        return PageRequest.of(page, size, sort);
    }

}

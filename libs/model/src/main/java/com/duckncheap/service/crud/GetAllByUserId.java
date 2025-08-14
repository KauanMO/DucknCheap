package com.duckncheap.service.crud;

import java.util.List;

public interface GetAllByUserId<T> {
    List<T> getAllByUserId(Long userId);
}

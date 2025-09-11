package com.duckncheap.shared.crud;

import java.util.List;

public interface GetAllByUserId<T> {
    List<T> getAllByUserId(Long userId);
}

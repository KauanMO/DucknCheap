package com.duckncheap.shared.crud;

public interface CreateEntity<T, DTO> {
    T create(DTO dto);
}

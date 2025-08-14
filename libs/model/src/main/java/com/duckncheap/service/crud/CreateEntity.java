package com.duckncheap.service.crud;

public interface CreateEntity<T, DTO> {
    T create(DTO dto);
}

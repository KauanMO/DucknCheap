package com.DucknCheap.service.crud;

public interface CreateEntity<T, DTO> {
    T create(DTO dto);
}

package com.DucknCheap.service.user;

import com.DucknCheap.dto.user.InCreateUserDTO;
import com.DucknCheap.service.crud.CreateEntity;
import com.duckncheap.model.User;

public interface UserService extends CreateEntity<User, InCreateUserDTO> {
}

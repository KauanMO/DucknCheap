package com.DucknCheap.service.user;

import com.DucknCheap.dto.user.createUser.InCreateUserDTO;
import com.DucknCheap.dto.user.login.InLoginDTO;
import com.DucknCheap.service.crud.CreateEntity;
import com.DucknCheap.service.crud.GetById;
import com.duckncheap.model.User;

public interface UserService extends
        CreateEntity<User, InCreateUserDTO>,
        GetById<User> {
    User login(InLoginDTO dto);
}

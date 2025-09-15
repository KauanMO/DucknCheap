package com.duckncheap.users.service.user;

import com.duckncheap.users.dto.user.createUser.InCreateUserDTO;
import com.duckncheap.users.dto.user.login.InLoginDTO;
import com.duckncheap.shared.crud.CreateEntity;
import com.duckncheap.shared.crud.GetById;
import com.duckncheap.shared.model.User;

public interface UserService extends
        CreateEntity<User, InCreateUserDTO>,
        GetById<User> {
    User login(InLoginDTO dto);
}

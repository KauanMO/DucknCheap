package com.DucknCheap.service.user;

import com.DucknCheap.dto.user.InCreateUserDTO;
import com.DucknCheap.repository.UserRepository;
import com.DucknCheap.service.exceptions.EmailAlreadyUsedException;
import com.duckncheap.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public User create(InCreateUserDTO inCreateUserDTO) {
        if (repository.existsByEmail(inCreateUserDTO.email())) throw new EmailAlreadyUsedException();

        User user = User.builder()
                .email(inCreateUserDTO.email())
                .password(inCreateUserDTO.password())
                .build();

        return repository.save(user);
    }
}

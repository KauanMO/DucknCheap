package com.duckncheap.users.service.user;

import com.duckncheap.users.dto.user.createUser.InCreateUserDTO;
import com.duckncheap.users.dto.user.login.InLoginDTO;
import com.duckncheap.users.repository.UserRepository;
import com.duckncheap.users.service.exceptions.EmailAlreadyUsedException;
import com.duckncheap.users.service.exceptions.IncorrectPasswordException;
import com.duckncheap.shared.exception.UserNotFoundException;
import com.duckncheap.shared.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;

    @Override
    public User create(InCreateUserDTO inCreateUserDTO) {
        if (repository.existsByEmail(inCreateUserDTO.email())) throw new EmailAlreadyUsedException();

        User user = User.builder()
                .email(inCreateUserDTO.email())
                .password(encoder.encode(inCreateUserDTO.password()))
                .build();

        return repository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User login(InLoginDTO dto) {
        User userFound = repository.findByEmail(dto.email()).orElseThrow(UserNotFoundException::new);

        if (!encoder.matches(dto.password(), userFound.getPassword()))
            throw new IncorrectPasswordException();

        return userFound;
    }

    @Override
    public User getById(Long id) {
        return repository.findById(id).orElseThrow(UserNotFoundException::new);
    }
}

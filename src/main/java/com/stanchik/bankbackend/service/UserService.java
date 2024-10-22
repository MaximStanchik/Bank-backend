package com.stanchik.bankbackend.service;

import com.stanchik.bankbackend.model.User;
import com.stanchik.bankbackend.model.dto.user.registration.RegisterUserRequestDto;
import com.stanchik.bankbackend.model.dto.user.registration.RegisterUserResponseDto;
import com.stanchik.bankbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public RegisterUserResponseDto register (RegisterUserRequestDto requestDto) {
        userRepository.findByLogin(requestDto.login())
                .map(user -> {throw new RuntimeException("user already exists");});

        if (!validateUserInput(requestDto.login(), requestDto.password())) {
            throw new RuntimeException("Login or password are not valid");
        }
        else {
            User user = userRepository.save(new User(null, requestDto.login(), requestDto.password(), new ArrayList<>()));
            return new RegisterUserResponseDto(user.getId(), user.getLogin());
        }
    }

    public boolean validateUserInput (String login, String password) {
        if (!login.matches("[a-zA-Z0-9]{2,255}") || !password.matches("[a-zA-Z0-9%!\\-:;]{2,255}")) {
            return false;
        }
        else {
            return true;
        }
    }

    //TODO: дописать еще методы те что в дто у меня описаны. Дописать схему бд. Дописать все остальные сервисы. Потом надо будет проверить что все вообще работает. Потом дописать контроллеры. Потом написать фронтенд.
}
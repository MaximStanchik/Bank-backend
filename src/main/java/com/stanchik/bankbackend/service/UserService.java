package com.stanchik.bankbackend.service;

import com.stanchik.bankbackend.model.User;
import com.stanchik.bankbackend.model.dto.user.info.UpdateLoginAndPasswordRequestDto;
import com.stanchik.bankbackend.model.dto.user.login.LoginRequestDto;
import com.stanchik.bankbackend.model.dto.user.login.LoginResponseDto;
import com.stanchik.bankbackend.model.dto.user.registration.RegisterUserRequestDto;
import com.stanchik.bankbackend.model.dto.user.registration.RegisterUserResponseDto;
import com.stanchik.bankbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private static final SecureRandom secureRandom = new SecureRandom(); //threadsafe
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); //threadsafe

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

    public static String generateNewToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }

    public LoginResponseDto login (LoginRequestDto requestDto) {

        return userRepository.findByLogin(requestDto.login()).map(user -> {
            if (user.getPassword().equals(requestDto.password())) {
                return new LoginResponseDto(user.getId(), generateNewToken());
            }
            else {
                throw new RuntimeException("User password doesn't match");
            }
        }).orElseThrow();

    }

    public void updateUser(UpdateLoginAndPasswordRequestDto requestDto) {
        userRepository.findById(requestDto.userId()).map(user -> {
            if (user.getPassword().equals(requestDto.oldPassword())) {
                user.setLogin(requestDto.newLogin());
                user.setPassword(requestDto.newPassword());
                return userRepository.save(user);
            }
            else {
                throw new RuntimeException("User password doesn't match");
            }
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<User> getAll() {
        return Streamable.of(userRepository.findAll()).toList();
    }

    //TODO: дописать еще методы те что в дто у меня описаны. Дописать схему бд. Дописать все остальные сервисы. Потом надо будет проверить что все вообще работает. Потом дописать контроллеры. Потом написать фронтенд.
    //TODO: дописать контроллеры и сервисы, создание объектов в бд + попробовать найти в оракле созданные таблицы

}
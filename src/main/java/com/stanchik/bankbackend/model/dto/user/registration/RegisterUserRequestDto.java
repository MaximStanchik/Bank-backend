package com.stanchik.bankbackend.model.dto.user.registration;

public record RegisterUserRequestDto(String login, String password, String confirmPassword) { // Регистрация нового пользователя
    // TODO: логин должен быть уникальным (проверка через репозиторий в сервисе)
    // TODO: пароль должен соответствовать критериям надежности (проверка в сервисе)
};

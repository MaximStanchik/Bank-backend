package com.stanchik.bankbackend.model.dto.user.registration;

public record RegisterUserResponseDto(Long userId, String login) { // Ответ на регистрацию нового пользователя
    // TODO: ответ в виде ошибки или перехода на другую страницу с продолжением ввода данных для регистрации (имя, фамилия и дрю)
};

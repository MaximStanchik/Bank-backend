package com.stanchik.bankbackend.model.dto.user.login;

public record LoginResponseDto(Long userId, String token) { // Возврат информации после успешного входа пользователя
    //String token = createToken(userId);
    //return new LoginResponseDto(userId, token); ????
};

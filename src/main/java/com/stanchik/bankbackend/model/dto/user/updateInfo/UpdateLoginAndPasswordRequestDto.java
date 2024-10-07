package com.stanchik.bankbackend.model.dto.user.updateInfo;

public record UpdateLoginAndPasswordRequestDto(Long userId, String newLogin, String oldPassword, String newPassword) {

};

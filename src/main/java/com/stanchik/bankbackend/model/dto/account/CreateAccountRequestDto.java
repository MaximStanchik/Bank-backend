package com.stanchik.bankbackend.model.dto.account;

import java.math.BigDecimal;

public record CreateAccountRequestDto(Long userId, String name, String currency) {

}

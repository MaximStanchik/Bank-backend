package com.stanchik.bankbackend.service;

import com.stanchik.bankbackend.model.Account;
import com.stanchik.bankbackend.model.Currency;
import com.stanchik.bankbackend.model.User;
import com.stanchik.bankbackend.model.dto.account.CreateAccountRequestDto;
import com.stanchik.bankbackend.model.dto.account.CreateAccountResponseDto;
import com.stanchik.bankbackend.repository.AccountRepository;
import com.stanchik.bankbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final CurrencyService currencyService;

    public CreateAccountResponseDto createAccount(CreateAccountRequestDto dto) {
        User user = userRepository.findById(dto.userId())
                .orElseThrow(() -> new RuntimeException("User not found by ID: " + dto.userId()));
        Currency currency = currencyService.findByName(dto.currency());
        Account account = new Account();
        account.setName(dto.name());
        account.setCurrency(currency.getName());
        account.setUser(user);
        accountRepository.save(account);
        return new CreateAccountResponseDto(true);
    }

    public Account findById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found by ID: " + id));
    }

}

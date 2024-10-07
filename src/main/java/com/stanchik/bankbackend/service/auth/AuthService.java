package com.stanchik.bankbackend.service.auth;

import com.stanchik.bankbackend.model.dto.user.registration.RegisterUserRequestDto;
import com.stanchik.bankbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    /**
     *
     * @param requestDto
     */
    public void registerUser(RegisterUserRequestDto requestDto)  {

    }

}

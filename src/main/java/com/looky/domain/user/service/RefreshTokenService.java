package com.looky.domain.user.service;

import com.looky.domain.user.entity.RefreshToken;
import com.looky.domain.user.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public void save(Long userId, String refreshToken) {
        RefreshToken token = RefreshToken.builder()
                .userId(userId)
                .token(refreshToken)
                .expiryDate(LocalDateTime.now().plusDays(14))
                .build();
        refreshTokenRepository.save(token);
    }

    @Transactional(readOnly = true)
    public String getByUserId(Long userId) {
        return refreshTokenRepository.findById(userId)
                .map(RefreshToken::getToken)
                .orElse(null);
    }

    @Transactional
    public void delete(Long userId) {
        refreshTokenRepository.deleteById(userId);
    }
}

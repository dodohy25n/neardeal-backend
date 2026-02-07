package com.looky.domain.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResetPasswordRequest {
    @NotBlank
    private String resetToken;

    @NotBlank
    private String newPassword;
}

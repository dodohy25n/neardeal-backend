package com.looky.domain.user.dto;

import com.looky.domain.user.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OwnerSignupRequest {
    private String username; // 아이디 (이메일X)
    private String password;
    private String email;
    private Gender gender;
    private LocalDate birthDate;

    private String name;
}

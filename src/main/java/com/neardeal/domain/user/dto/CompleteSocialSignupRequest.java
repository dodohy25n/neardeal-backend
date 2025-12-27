package com.neardeal.domain.user.dto;

import com.neardeal.domain.user.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompleteSocialSignupRequest {
    private String phoneNumber;
    private Role role;

    private Long universityId;      // Customer인 경우
    private String businessNumber;  // Owner인 경우
}

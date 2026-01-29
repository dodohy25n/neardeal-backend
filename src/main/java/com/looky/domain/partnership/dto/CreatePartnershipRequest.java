package com.looky.domain.partnership.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class CreatePartnershipRequest {

    @NotNull(message = "상점 ID는 필수입니다.")
    private Long storeId;

    @NotNull(message = "조직 ID는 필수입니다.")
    private Long organizationId;

    @NotBlank(message = "혜택 내용은 필수입니다.")
    private String benefit;

    @NotNull(message = "시작일은 필수입니다.")
    private LocalDate startsAt;

    @NotNull(message = "종료일은 필수입니다.")
    private LocalDate endsAt;
}

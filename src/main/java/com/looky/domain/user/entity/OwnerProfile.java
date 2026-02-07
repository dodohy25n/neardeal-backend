package com.looky.domain.user.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OwnerProfile {

    @Id
    private Long userId;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId // User의 PK를 이 테이블의 PK이자 FK로 사용
    @JoinColumn(name = "user_id")
    private User user;

    private String name;

    @Builder
    public OwnerProfile(User user, String name) {
        this.user = user;
        this.name = name;
    }
}

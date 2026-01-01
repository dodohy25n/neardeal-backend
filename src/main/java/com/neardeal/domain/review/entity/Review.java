package com.neardeal.domain.review.entity;

import com.neardeal.common.entity.BaseEntity;
import com.neardeal.domain.coupon.entity.CustomerCoupon;
import com.neardeal.domain.store.entity.Store;
import com.neardeal.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_review_id")
    private Review parentReview; // 답글인 경우 원본 리뷰 ID

    @Column(nullable = false)
    private boolean isVerified; // 구매인증여부 (쿠폰사용여부로 판단)

    @Column(nullable = false)
    private int rating;

    @Lob
    private String content;

    @Builder
    public Review(User user, Store store, Review parentReview, boolean isVerified, int rating, String content) {
        this.user = user;
        this.store = store;
        this.parentReview = parentReview;
        this.isVerified = isVerified;
        this.rating = rating;
        this.content = content;
    }

    public void updateReview(String content, Integer rating, Boolean isVerified) {
        if (content != null) {
            this.content = content;
        }
        if (rating != null) {
            this.rating = rating;
        }
        if (isVerified != null) {
            this.isVerified = isVerified;
        }
    }
}

package com.neardeal.domain.coupon.repository;

import com.neardeal.domain.coupon.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    List<Coupon> findByStoreId(Long storeId);
}

package com.neardeal.domain.coupon.repository;

import com.neardeal.domain.coupon.entity.CustomerCoupon;
import com.neardeal.domain.user.entity.User;
import com.neardeal.domain.coupon.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerCouponRepository extends JpaRepository<CustomerCoupon, Long> {
    Integer countByCouponAndUser(Coupon coupon, User user);

    Long countByCoupon(Coupon coupon);

    List<CustomerCoupon> findByUser(User user);

    Optional<CustomerCoupon> findByIdAndUser(Long id, User user);
}

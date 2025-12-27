package com.neardeal.domain.coupon.repository;

import com.neardeal.domain.coupon.entity.CouponItem;
import com.neardeal.domain.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CouponItemRepository extends JpaRepository<CouponItem, Long> {
    List<CouponItem> findByItem(Item item);
}

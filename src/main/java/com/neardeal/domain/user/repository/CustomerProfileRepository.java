package com.neardeal.domain.user.repository;

import com.neardeal.domain.user.entity.CustomerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerProfileRepository extends JpaRepository<CustomerProfile, Long> {
}

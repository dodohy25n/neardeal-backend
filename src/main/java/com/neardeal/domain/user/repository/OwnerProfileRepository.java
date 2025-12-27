package com.neardeal.domain.user.repository;

import com.neardeal.domain.user.entity.OwnerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerProfileRepository extends JpaRepository<OwnerProfile, Long> {
}

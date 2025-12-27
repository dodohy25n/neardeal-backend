package com.neardeal.domain.affiliation.repository;

import com.neardeal.domain.affiliation.entity.Affiliation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AffiliationRepository extends JpaRepository<Affiliation, Long> {
}

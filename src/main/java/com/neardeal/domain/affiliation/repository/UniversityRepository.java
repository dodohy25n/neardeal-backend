package com.neardeal.domain.affiliation.repository;

import com.neardeal.domain.affiliation.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepository extends JpaRepository<University, Long> {
}

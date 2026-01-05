package com.neardeal.domain.review.repository;

import com.neardeal.domain.review.entity.Review;
import com.neardeal.domain.review.entity.ReviewReport;
import com.neardeal.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewReportRepository extends JpaRepository<ReviewReport, Long> {
    boolean existsByReviewAndReporter(Review review, User reporter);
}

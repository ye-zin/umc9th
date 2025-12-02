package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.entity.Review;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ReviewQueryDsl {
    List<Review> findMyReviews(Long memberId, String storeName, Double reviewScore, PageRequest pageRequest);
}

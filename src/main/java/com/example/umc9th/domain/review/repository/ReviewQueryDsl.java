package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.dto.response.MyReviewDTO;

import java.util.List;


public interface ReviewQueryDsl {
    List<MyReviewDTO> findMyReviews(Long memberId, String storeName, Double reviewScore);
}

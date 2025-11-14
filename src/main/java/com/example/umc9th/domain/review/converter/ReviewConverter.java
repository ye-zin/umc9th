package com.example.umc9th.domain.review.converter;

import com.example.umc9th.domain.review.dto.response.MyReviewDTO;
import com.example.umc9th.domain.review.entity.Review;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {

    public static MyReviewDTO toMyReviewDTO(Review review){
        return MyReviewDTO.builder()
                .reviewId(review.getId())
                .storeId(review.getStore().getId())
                .storeName(review.getStore().getStoreName())
                .reviewScore(review.getReviewScore())
                .reviewContent(review.getReviewContent())
                .reviewImage(review.getReviewImageList())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public static List<MyReviewDTO> toMyReviewDTOList(List<Review> reviews) {
        return reviews.stream()
                .map(ReviewConverter::toMyReviewDTO)
                .collect(Collectors.toList());
    }
}

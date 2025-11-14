package com.example.umc9th.domain.review.dto.response;

import com.example.umc9th.domain.review.entity.ReviewImage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class MyReviewDTO {
    private Long reviewId;
    private Long storeId;
    private String storeName;
    private Double reviewScore;
    private String reviewContent;
    private List<ReviewImage> reviewImage;
    private LocalDateTime createdAt;
}

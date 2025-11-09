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
    Long reviewId;
    String storeName;
    Double reviewScore;
    String reviewBody;
    List<ReviewImage> reviewImage;
    LocalDateTime createdAt;
}

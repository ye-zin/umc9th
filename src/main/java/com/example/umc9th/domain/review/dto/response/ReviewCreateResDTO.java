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
public class ReviewCreateResDTO {
    private Long reviewId;
    private Long storeId;
    private Long memberId;
    private String reviewContent;
    private Double reviewScore;
    private List<String> reviewImage;
    private LocalDateTime createdAt;
}

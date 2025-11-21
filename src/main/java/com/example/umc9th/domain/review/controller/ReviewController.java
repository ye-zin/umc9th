package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.response.MyReviewDTO;
import com.example.umc9th.domain.review.service.ReviewService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    // 내가 작성한 리뷰 보기
    @GetMapping("/me")
    public ApiResponse<List<MyReviewDTO>> getMyReviews(
            @RequestParam Long memberId,
            @RequestParam(required = false) String storeName,
            @RequestParam(required = false) Double reviewScore
    ){
        List<MyReviewDTO> myreviews = reviewService.getMyReviews(memberId, storeName, reviewScore);
        return ApiResponse.onSuccess(GeneralSuccessCode.SUCCESS, myreviews);
    }
}

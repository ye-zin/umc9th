package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.response.MyReviewDTO;
import com.example.umc9th.domain.review.dto.response.ReviewResDTO;
import com.example.umc9th.domain.review.exception.code.ReviewSuccessCode;
import com.example.umc9th.domain.review.service.ReviewService;
import com.example.umc9th.domain.review.service.query.ReviewQueryService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController implements ReviewControllerDocs{

    private final ReviewService reviewService;
    private final ReviewQueryService reviewQueryService;

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

    // 가게의 리뷰 목록 조회
    @GetMapping("/reviews")
    public ApiResponse<ReviewResDTO.ReviewPreViewListDTO> getReviews(
            @RequestParam String storeName,
            @RequestParam Integer page
    ){
        ReviewSuccessCode code = ReviewSuccessCode.FOUND;
        return ApiResponse.onSuccess(code, reviewQueryService.findReview(storeName, page));
    }
}

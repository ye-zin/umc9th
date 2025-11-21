package com.example.umc9th.domain.store.controller;

import com.example.umc9th.domain.review.dto.request.ReviewCreateReqDTO;
import com.example.umc9th.domain.review.dto.response.ReviewCreateResDTO;
import com.example.umc9th.domain.review.service.ReviewService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stores")
public class StoreController {

    private final ReviewService reviewService;

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<ReviewCreateResDTO> createReview(
            @PathVariable Long storeId,
            @RequestParam Long memberId,
            @RequestBody ReviewCreateReqDTO dto) {
        ReviewCreateResDTO review = reviewService.createReview(memberId, storeId, dto);
        return ApiResponse.onSuccess(GeneralSuccessCode.SUCCESS, review);
    }
}

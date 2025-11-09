package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.response.MyReviewDTO;
import com.example.umc9th.domain.review.service.ReviewService;
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

    @GetMapping("/me")

    public List<MyReviewDTO> getMyReviews(
            @RequestParam Long memberId,
            @RequestParam(required = false) String storeName,
            @RequestParam(required = false) Double reviewScore
    ){
        return reviewService.getMyReviews(memberId, storeName, reviewScore);
    }
}

package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.example.umc9th.domain.store.entity.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Transactional
    public Review createReview(Member member, Store store, String reviewBody, Double score)
    {
        Review review = Review.builder()
                              .member(member)
                              .store(store)
                              .reviewBody(reviewBody)
                              .reviewScore(score)
                              .build();

        return reviewRepository.save(review);
    }

}

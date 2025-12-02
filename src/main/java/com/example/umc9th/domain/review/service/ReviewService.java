package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.domain.review.converter.ReviewConverter;
import com.example.umc9th.domain.review.dto.request.ReviewCreateReqDTO;
import com.example.umc9th.domain.review.dto.response.MyReviewDTO;
import com.example.umc9th.domain.review.dto.response.ReviewCreateResDTO;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.repository.StoreRepository;
import com.example.umc9th.global.apiPayload.code.GeneralErrorCode;
import com.example.umc9th.global.apiPayload.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public ReviewCreateResDTO createReview(Long memberId, Long storeId, ReviewCreateReqDTO dto){
        // 1) 가게 검증
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new GeneralException(GeneralErrorCode.NOT_FOUND));

        // 2) 회원 검증
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new GeneralException(GeneralErrorCode.NOT_FOUND));

        // Entity -> DTO
        Review review = ReviewConverter.toReview(dto, store, member);

        // DB에 리뷰 저장
        Review savedReview = reviewRepository.save(review);

        return ReviewConverter.toCreateReviewResponse(savedReview);
    }

    public List<MyReviewDTO> getMyReviews(Long memberId, String storeName, Double reviewScore, Integer page) {
        PageRequest pageable = PageRequest.of(page - 1, 10);
        List<Review> reviews = reviewRepository.findMyReviews(memberId, storeName, reviewScore, pageable);

        return ReviewConverter.toMyReviewDTOList(reviews);
    }
}

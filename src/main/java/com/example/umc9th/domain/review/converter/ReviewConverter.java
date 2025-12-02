package com.example.umc9th.domain.review.converter;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.review.dto.request.ReviewCreateReqDTO;
import com.example.umc9th.domain.review.dto.response.MyReviewDTO;
import com.example.umc9th.domain.review.dto.response.ReviewCreateResDTO;
import com.example.umc9th.domain.review.dto.response.ReviewResDTO;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.entity.ReviewImage;
import com.example.umc9th.domain.store.entity.Store;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {
    // 리뷰 생성용 엔티티 변환
    public static Review toReview(ReviewCreateReqDTO dto, Store store, Member member) {
        Review review = Review.builder()
                .reviewContent(dto.getReviewContent())
                .reviewScore(dto.getReviewScore())
                .store(store)
                .member(member)
                .build();

        // 이미지 URL 리스트가 있다면 ReviewImage 엔티티로 변환
        List<String> imageUrls = dto.getReviewImage();
        if (imageUrls != null && !imageUrls.isEmpty()) {
            List<ReviewImage> reviewImages = new ArrayList<>();

            for (String url : imageUrls) {
                ReviewImage reviewImage = ReviewImage.builder()
                        .reviewImage(url)
                        .review(review)
                        .build();
                reviewImages.add(reviewImage);
            }

            // Review ↔ ReviewImage 양방향 세팅
            review.getReviewImageList().addAll(reviewImages);
        }

        return review;
    }

    // 가게에 리뷰 작성
    public static ReviewCreateResDTO toCreateReviewResponse(Review review){
        List<String> imageUrls = review.getReviewImageList().stream()
                .map(ReviewImage::getReviewImage)
                .toList();

        return ReviewCreateResDTO.builder()
                .reviewId(review.getId())
                .storeId(review.getStore().getId())
                .memberId(review.getMember().getId())
                .reviewContent(review.getReviewContent())
                .reviewScore(review.getReviewScore())
                .reviewImage(imageUrls)
                .createdAt(review.getCreatedAt())
                .build();
    }


    // 내 리뷰 조회용 : Entity -> DTO
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

    // Review 여러 개 -> DTO 여러 개. ex) 마이페이지에서 내가 쓴 리뷰 목록 조회
    public static List<MyReviewDTO> toMyReviewDTOList(List<Review> reviews) {
        return reviews.stream()
                .map(ReviewConverter::toMyReviewDTO)
                .collect(Collectors.toList());
    }

    // result -> DTO
    public static ReviewResDTO.ReviewPreViewListDTO toReviewPreviewListDTO(Page<Review> result){
        return ReviewResDTO.ReviewPreViewListDTO.builder()
                .reviewList(result.getContent().stream()
                        .map(ReviewConverter::toReviewPreviewDTO)
                        .toList()
                )
                .listSize(result.getSize())
                .totalPage(result.getTotalPages())
                .totalElements(result.getTotalElements())
                .isFirst(result.isFirst())
                .isLast(result.isLast())
                .build();
    }

    public static ReviewResDTO.ReviewPreViewDTO toReviewPreviewDTO(
            Review review
    ){
        return ReviewResDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getReviewScore())
                .body(review.getReviewContent())
                .createdAt(LocalDate.from(review.getCreatedAt()))
                .build();
    }
}

package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.entity.QReview;
import com.example.umc9th.domain.review.entity.QReviewImage;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.store.entity.QStore;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewQueryDslImpl implements ReviewQueryDsl {

    private final EntityManager em;

    @Override
    public List<Review> findMyReviews(Long memberId, String storeName, Double reviewScore, PageRequest pageRequest) {

        // JPA 세팅
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        // Q클래스 선언
        QReview review = QReview.review;
        QStore store = QStore.store;
        QReviewImage reviewImage = new QReviewImage("reviewImage"); // Q클래스에는 reviewImage1이라고 선언되어 있어서 바꿔주기

        // 내가 쓴 리뷰
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(review.member.id.eq(memberId));

        // 가게 별 필터
        if (storeName != null && !storeName.isBlank()) {
            builder.and(review.store.storeName.eq(storeName));
        }

        // 별점 대 필터
        if (reviewScore != null) {
            double minScore = reviewScore.doubleValue();
            double maxScore = reviewScore + 0.9; // reviewScore ~ (reviewScore+0.9)
            builder.and(review.reviewScore.between(minScore, maxScore));
        }

        // 쿼리 실행 (최신순)
        // DB에 저장되어 있는 review를 불러오는 거기 떄문에 DTO가 아니고 Entity로 선언
        return queryFactory
                .selectFrom(review)
                .join(review.store, store).fetchJoin() // 가게 정보 함께 조회
                .leftJoin(review.reviewImageList, reviewImage).fetchJoin() // 리뷰 이미지 fetch join
                .where(builder)
                .orderBy(review.createdAt.desc())
                .fetch();
    }
}

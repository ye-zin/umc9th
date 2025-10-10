package com.example.umc9th.domain.review.entity;

import com.example.umc9th.global.Entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "reply")
public class Reply extends BaseEntity {

    @Column(name = "content", nullable = false)
    private String replyContent;
}

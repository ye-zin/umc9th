package com.example.umc9th.domain.term.entity;

import com.example.umc9th.domain.term.enums.TermName;
import com.example.umc9th.global.Entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "term")
public class Term extends BaseEntity {

    @Column(name = "name", nullable = false)
    @Enumerated(EnumType.STRING)
    private TermName termName;

    @Column(name = "content")
    private String termContent;

    @Column(name = "is_required", nullable = false)
    private Boolean isRequired;

    @Column(name = "version")
    private String version;
}

package com.example.umc9th.domain.member.dto.reponse;

import lombok.Builder;

import java.time.LocalDateTime;

public class MemberResDTO {

    // 로그인
    @Builder
    public record JoinDTO(
            Long memberId,
            LocalDateTime createAt
    ){}

    // 회원가입
    @Builder
    public record LoginDTO(
            Long memberId,
            String accessToken
    ){}
}

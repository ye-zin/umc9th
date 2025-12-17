package com.example.umc9th.domain.member.dto.request;

import com.example.umc9th.domain.member.enums.Gender;
import com.example.umc9th.domain.member.enums.SocialType;
import com.example.umc9th.global.ExistFoods;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public class MemberReqDTO {

        public record JoinDTO(
            @NotBlank
            String name,
            @Email
            String email,       // 추가
            @NotBlank
            String password,    // 추가
            @NotBlank
            String phone,
            @NotBlank
            String nickname,
            @NotNull
            Gender gender,
            @NotNull
            LocalDate birth,
            @NotNull
            String address,
            @NotNull
            String specAddress,
            @ExistFoods
            List<Long> preferCategory,
            // 로그인 방식
            SocialType socialType
        ){}

        // 로그인
        public record LoginDTO(
                @NotBlank
                String email,
                @NotBlank
                String password
        ){}
}

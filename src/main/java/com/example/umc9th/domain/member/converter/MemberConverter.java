package com.example.umc9th.domain.member.converter;

import com.example.umc9th.domain.member.dto.reponse.MemberResDTO;
import com.example.umc9th.domain.member.dto.request.MemberReqDTO;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.global.auth.enums.Role;

public class MemberConverter {

    // Entity -> DTO
    public static MemberResDTO.JoinDTO toJoinDTO(Member member) {
        return MemberResDTO.JoinDTO.builder()
                .memberId(member.getId())
                .createAt(member.getCreatedAt())
                .build();
    }

    // DTO, Salted Password, Role -> Entity
    public static Member toMember(MemberReqDTO.JoinDTO dto, String password, Role role){
        return Member.builder()
                .name(dto.name())
                .email(dto.email())     // 추가
                .password(password)     // 추가
                .role(role)             // 추가
                .socialType(dto.socialType())
                .nickname(dto.nickname())
                .phone(dto.phone())
                .birth(dto.birth())
                .address(dto.address())
                .specAddress(dto.specAddress())
                .gender(dto.gender())
                .build();
    }

    // Entity -> DTO
    public static MemberResDTO.LoginDTO toLoginDTO(Member member, String accessToken) {
        return MemberResDTO.LoginDTO.builder()
                .memberId(member.getId())
                .accessToken(accessToken)
                .build();
    }
}

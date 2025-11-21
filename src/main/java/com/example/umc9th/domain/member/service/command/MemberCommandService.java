package com.example.umc9th.domain.member.service.command;

import com.example.umc9th.domain.member.dto.reponse.MemberResDTO;
import com.example.umc9th.domain.member.dto.request.MemberReqDTO;

public interface MemberCommandService {
    // 회원가입
    MemberResDTO.JoinDTO signup(MemberReqDTO.JoinDTO dto);
}

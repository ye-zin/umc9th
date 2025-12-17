package com.example.umc9th.domain.member.service.query;

import com.example.umc9th.domain.member.dto.reponse.MemberResDTO;
import com.example.umc9th.domain.member.dto.request.MemberReqDTO;
import jakarta.validation.Valid;

public interface MemberQueryService {
    MemberResDTO.LoginDTO login(MemberReqDTO.@Valid LoginDTO dto);
}

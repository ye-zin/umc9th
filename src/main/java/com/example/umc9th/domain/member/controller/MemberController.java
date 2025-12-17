package com.example.umc9th.domain.member.controller;

import com.example.umc9th.domain.member.dto.reponse.MemberResDTO;
import com.example.umc9th.domain.member.dto.request.MemberReqDTO;
import com.example.umc9th.domain.member.exception.code.MemberSuccessCode;
import com.example.umc9th.domain.member.service.command.MemberCommandService;
import com.example.umc9th.domain.member.service.query.MemberMissionQueryService;
import com.example.umc9th.domain.member.service.query.MemberQueryService;
import com.example.umc9th.domain.mission.dto.response.MemberMissionDTO;
import com.example.umc9th.domain.mission.enums.MissionStatus;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberCommandService memberCommandService;
    private final MemberMissionQueryService memberMissionQueryService;
    private final MemberQueryService memberQueryService;

    // 회원가입
    @PostMapping("/sign-up")
    public ApiResponse<MemberResDTO.JoinDTO> signUp(@RequestBody @Valid MemberReqDTO.JoinDTO dto){
        return ApiResponse.onSuccess(MemberSuccessCode.FOUND, memberCommandService.signup(dto));
    }

    // 로그인
    @PostMapping("/login")
    public ApiResponse<MemberResDTO.LoginDTO> login(@RequestBody @Valid MemberReqDTO.LoginDTO dto){
        return ApiResponse.onSuccess(MemberSuccessCode.FOUND, memberQueryService.login(dto));
    }

    // 내가 진행중인 미션 확인하기
    @GetMapping("/missions/me")
    public ApiResponse<Page<MemberMissionDTO>> getMyMissions(
            @RequestParam Long memberId,
            @RequestParam MissionStatus status,   // IN_PROGRESS or COMPLETED
            @RequestParam Integer page
    ){
        Page<MemberMissionDTO> myMissions = memberMissionQueryService.getMemberMissions(memberId, status, page);
        return ApiResponse.onSuccess(GeneralSuccessCode.SUCCESS, myMissions);
    }
}

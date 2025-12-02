package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.response.MissionDTO;
import com.example.umc9th.domain.mission.dto.response.MissionResDTO;
import com.example.umc9th.domain.mission.exception.code.MissionSuccessCode;
import com.example.umc9th.domain.mission.service.MissionService;
import com.example.umc9th.domain.mission.service.query.MissionQueryService;
import com.example.umc9th.domain.review.dto.response.MyReviewDTO;
import com.example.umc9th.domain.review.dto.response.ReviewResDTO;
import com.example.umc9th.domain.review.exception.code.ReviewSuccessCode;
import com.example.umc9th.global.annotiation.ValidPage;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/missions")
public class MissionController {

    private final MissionService missionService;
    private final MissionQueryService missionQueryService;

    // 미션 도전하기
    @PostMapping("/{missionId}/challenge")
    public ApiResponse<MissionDTO> challengeMission(
            @PathVariable Long missionId,
            @RequestParam Long memberId
    ) {
        MissionDTO mission = missionService.challengeMission(memberId, missionId);
        return ApiResponse.onSuccess(GeneralSuccessCode.SUCCESS, mission);
    }

    // 특정 가게의 미션 목록
    @GetMapping("/missions")
    public ApiResponse<MissionResDTO.MissionPreviewListDTO> getStoreMission(
            @RequestParam Long storeId,
            @RequestParam @ValidPage Integer page
    ){
        MissionSuccessCode code = MissionSuccessCode.FOUND;
        return ApiResponse.onSuccess(code, missionQueryService.findMissions(storeId,page));
    }
}

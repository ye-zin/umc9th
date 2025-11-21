package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.response.MissionDTO;
import com.example.umc9th.domain.mission.service.MissionService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/missions")
public class MissionController {

    private final MissionService missionService;

    // 미션 도전하기
    @PostMapping("/{missionId}/challenge")
    public ApiResponse<MissionDTO> challengeMission(
            @PathVariable Long missionId,
            @RequestParam Long memberId
    ) {
        MissionDTO mission = missionService.challengeMission(memberId, missionId);
        return ApiResponse.onSuccess(GeneralSuccessCode.SUCCESS, mission);
    }
}

package com.example.umc9th.domain.member.service.query;

import com.example.umc9th.domain.mission.dto.response.MemberMissionDTO;
import com.example.umc9th.domain.mission.enums.MissionStatus;
import org.springframework.data.domain.Page;

public interface MemberMissionQueryService {
    Page<MemberMissionDTO> getMemberMissions(Long memberId, MissionStatus status, Integer page);
}

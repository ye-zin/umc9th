package com.example.umc9th.domain.mission.dto.response;

import com.example.umc9th.domain.mission.enums.MissionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberMissionDTO {
    private Long memberMissionId;
    private MissionStatus missionStatus;
    private String missionSpec;
    private Integer reward;
    private String storeName;
}

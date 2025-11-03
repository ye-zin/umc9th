package com.example.umc9th.domain.mission.dto.responseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class MissionDTO {
    private Long missionId;
    private Integer reward;
    private LocalDateTime deadline;
    private String missionSpec;
    private Long storeId;
    private String storeName;
    private Long regionId;
    private String regionName;
}

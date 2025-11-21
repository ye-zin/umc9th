package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.mission.dto.response.MissionDTO;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.region.entity.Region;
import com.example.umc9th.domain.store.entity.Store;

public class MissionConverter {

    // Entity -> DTO
    public static MissionDTO toMissionDTO(Mission mission) {
        // 각 Entity에서 필요한 값만 꺼내서 쓰기 위해서
        Store store = mission.getStore();
        Region region = store.getRegion();

        return new MissionDTO(
                mission.getId(),
                mission.getReward(),
                mission.getDeadline(),
                mission.getMissionSpec(),
                store.getId(),
                store.getStoreName(),
                region.getId(),
                region.getRegionName()
        );
    }

}

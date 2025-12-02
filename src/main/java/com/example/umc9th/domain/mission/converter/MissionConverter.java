package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.mission.dto.response.MissionDTO;
import com.example.umc9th.domain.mission.dto.response.MissionResDTO;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.region.entity.Region;
import com.example.umc9th.domain.store.entity.Store;
import org.springframework.data.domain.Page;

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

    public static MissionResDTO.MissionPreviewListDTO toMissionPreviewListDTO(Page<Mission> missions) {
        return MissionResDTO.MissionPreviewListDTO.builder()
                .missionList(
                        missions.getContent().stream()
                                .map(MissionConverter::toMissionPreviewDTO)
                                .toList()
                )
                .listSize(missions.getSize())
                .totalPage(missions.getTotalPages())
                .totalElements(missions.getTotalElements())
                .isFirst(missions.isFirst())
                .isLast(missions.isLast())
                .build();
    }

    public static MissionResDTO.MissionPreviewDTO toMissionPreviewDTO(Mission mission) {
        return MissionResDTO.MissionPreviewDTO.builder()
                .missionId(mission.getId())
                .missionSpec(mission.getMissionSpec())
                .reward(mission.getReward())
                .deadline(mission.getDeadline().toString())
                .build();
    }
}

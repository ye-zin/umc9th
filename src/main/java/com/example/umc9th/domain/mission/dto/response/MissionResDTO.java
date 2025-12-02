package com.example.umc9th.domain.mission.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MissionResDTO {

    @Builder
    public record MissionPreviewDTO(
            Long missionId,
            String missionSpec,
            Integer reward,
            String deadline
    ) {}

    @Builder
    public record MissionPreviewListDTO(
            List<MissionPreviewDTO> missionList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ) {}
}

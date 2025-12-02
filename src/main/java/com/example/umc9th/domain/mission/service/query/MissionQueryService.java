package com.example.umc9th.domain.mission.service.query;

import com.example.umc9th.domain.mission.dto.response.MissionResDTO;

public interface MissionQueryService {
    MissionResDTO.MissionPreviewListDTO findMissions(Long storeId, Integer page);
}

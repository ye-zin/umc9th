package com.example.umc9th.domain.member.service.query;

import com.example.umc9th.domain.member.repository.MemberMissionRepository;
import com.example.umc9th.domain.mission.dto.response.MemberMissionDTO;
import com.example.umc9th.domain.mission.enums.MissionStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Page<MemberMissionDTO> getMemberMissions(Long memberId, MissionStatus status, Integer page) {
        PageRequest pageRequest = PageRequest.of(page - 1, 10);
        return memberMissionRepository.findMemberMissionsByStatus(memberId, status, pageRequest);
    }
}

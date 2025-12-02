package com.example.umc9th.domain.mission.service;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.entity.mapping.MemberMission;
import com.example.umc9th.domain.member.exception.code.MemberErrorCode;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.domain.mission.converter.MissionConverter;
import com.example.umc9th.domain.mission.dto.response.MissionDTO;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.member.repository.MemberMissionRepository;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import com.example.umc9th.domain.review.converter.ReviewConverter;
import com.example.umc9th.domain.review.dto.response.MyReviewDTO;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.store.repository.StoreRepository;
import com.example.umc9th.global.apiPayload.code.GeneralErrorCode;
import com.example.umc9th.global.apiPayload.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final StoreRepository storeRepository;

    // 미션 도전하기
    @Transactional
    public MissionDTO challengeMission(Long memberId, Long missionId) {

        // member, missio 조회
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new GeneralException(MemberErrorCode.NOT_FOUND));

        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new GeneralException(GeneralErrorCode.NOT_FOUND));


        // 미션 진행 상태 체크
        /* */

        // mission을 memeberMission에 추가
        MemberMission memberMission = MemberMission.create(member, mission);
        memberMissionRepository.save(memberMission);

        return MissionConverter.toMissionDTO(mission);
    }
}

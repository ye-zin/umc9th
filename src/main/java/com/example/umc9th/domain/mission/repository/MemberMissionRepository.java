package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.mission.dto.responseDTO.MemberMissionDTO;
import com.example.umc9th.domain.mission.enums.MissionStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberMissionRepository {

    // 미션 상태 파라미터로 받기
    @Query(value = """
        select new com.example.umc9th.domain.mission.dto.responseDTO.MemberMissionDTO(
            mm.id,
            mm.missionStatus,
            m.missionSpec,
            m.reward,
            s.storeName
        )
        from MemberMission mm
          join mm.mission m
          join m.store s
        where mm.member.id = :memberId
          and mm.missionStatus = :status
        order by mm.id desc
        """,
            countQuery = """
        select count(mm)
        from MemberMission mm
        where mm.member.id = :memberId
          and mm.missionStatus = :status
        """
    )
    Page<MemberMissionDTO> findMemberMissionsByStatus(
            @Param("memberId") Long memberId,
            @Param("status") MissionStatus missionStatus,
            Pageable pageable
    );

    // 진행 중, 진행 완료 탭 구분 -> 나중에 service에 추가
//    Page<MemberMissionDTO> findMemberInProgressMissions(Long memberId, Pageable pageable) {
//        return findMemberMissionsByStatus(memberId, MissionStatus.IN_PROGRESS, pageable);
//    }
//
//    Page<MemberMissionDTO> findMemberCompletedMissions(Long memberId, Pageable pageable) {
//        return findMemberMissionsByStatus(memberId, MissionStatus.COMPLETED, pageable);
//    }
}

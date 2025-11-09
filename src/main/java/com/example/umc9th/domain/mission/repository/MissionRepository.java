package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.mission.dto.response.MissionDTO;
import com.example.umc9th.domain.mission.entity.Mission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    @Query(
            value = """
          select new com.example.umc9th.domain.mission.dto.response.MissionDTO(
            m.id,
            m.reward,
            m.deadline,
            m.missionSpec,
            s.id,
            s.storeName,
            r.id,
            r.regionName
          )
          from Mission m
            join m.store s
            join s.region r
            left join MemberMission mm on mm.mission = m and mm.member.id = :memberId
          where r.id = :regionId
            and mm.id is null
            and m.deadline >= CURRENT_TIMESTAMP
          order by m.deadline desc, m.id asc
          """,
            countQuery = """
          select count(m)
          from Mission m
            join m.store s
            join s.region r
            left join MemberMission mm on mm.mission = m and mm.member.id = :memberId
          where r.id = :regionId
            and mm.id is null
            and m.deadline >= CURRENT_TIMESTAMP
          """
    )

    // Page:페이징 처리용 인터페이스(데이터 + 전체 페이지 정보 포함)
    Page<MissionDTO> findAvailableMissionsInRegion(
            @Param("memberId") Long memberId,
            @Param("regionId") Long regionId,
            Pageable pageable
    );

}

package com.example.umc9th.domain.member.entity.mapping;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.enums.MissionStatus;
import com.example.umc9th.global.Entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "member_mission")
public class MemberMission extends BaseEntity {

    @Column(name = "mission_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private MissionStatus missionStatus;

    @Column(name = "mission_started_date", nullable = false)
    private LocalDateTime missionStartedDate;

    @Column(name = "mission_completed_date")
    private LocalDateTime missionCompletedDate;

    @ManyToOne(fetch = FetchType.LAZY) // 지연 로딩
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY) // 지연 로딩
    @JoinColumn(name = "mission_id")
    private Mission mission;

    public static MemberMission create(Member member, Mission mission) {
        MemberMission mm = new MemberMission();
        mm.member = member;
        mm.mission = mission;
        mm.missionStatus = MissionStatus.IN_PROGRESS;
        mm.missionStartedDate = LocalDateTime.now();
        return mm;
    }
}

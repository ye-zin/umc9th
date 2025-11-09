package com.example.umc9th.domain.member.service;

import com.example.umc9th.domain.member.dto.reponse.MyPageDTO;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    public MyPageDTO getMyPage(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        MyPageDTO myPageDTO = new MyPageDTO(
                member.getNickname(),
                member.getEmail(),
                member.getPhone(),
                member.getPoint()
        );
        return myPageDTO;
    }
}

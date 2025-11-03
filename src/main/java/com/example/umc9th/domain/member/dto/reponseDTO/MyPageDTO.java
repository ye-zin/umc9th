package com.example.umc9th.domain.member.dto.reponseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MyPageDTO {
    String nickname;
    String email;
    String phone;
    Integer point;
}

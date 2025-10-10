package com.example.umc9th.domain.food.entity;

import com.example.umc9th.domain.food.enums.FoodName;
import com.example.umc9th.domain.member.entity.mapping.MemberFood;
import com.example.umc9th.global.Entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "food")
public class Food extends BaseEntity {

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private FoodName foodName;

    @OneToMany(mappedBy = "food")
    private List<MemberFood> memberFoodList = new ArrayList<>();
}
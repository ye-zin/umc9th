package com.example.umc9th.domain.region.entity;

import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.global.Entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "region")
public class Region extends BaseEntity {

    @Column(name = "name")
    private String regionName;

    @OneToMany(mappedBy = "region")
    private List<Store> storeList = new ArrayList<>();
}

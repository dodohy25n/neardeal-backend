package com.neardeal.domain.store.entity;

import com.neardeal.common.entity.BaseEntity;
import com.neardeal.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "store")
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    private Double latitude;
    private Double longitude;

    private String phoneNumber;

    @Lob
    private String introduction;

    @Lob
    private String operatingHours; // JSON String

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StoreCategory storeCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Owner

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StoreImage> images = new ArrayList<>();


    @Builder
    public Store(User user, String name, String address, Double latitude, Double longitude, String phoneNumber,
            String introduction, String operatingHours, StoreCategory storeCategory) {
        this.user = user;
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.phoneNumber = phoneNumber;
        this.introduction = introduction;
        this.operatingHours = operatingHours;
        this.storeCategory = storeCategory;
    }

    public void updateStore(String name, String address, Double latitude, Double longitude, String phoneNumber,
            String introduction, String operatingHours, StoreCategory storeCategory) {
        if (name != null) {
            this.name = name;
        }
        if (address != null) {
            this.address = address;
        }
        if (latitude != null) {
            this.latitude = latitude;
        }
        if (longitude != null) {
            this.longitude = longitude;
        }
        if (phoneNumber != null) {
            this.phoneNumber = phoneNumber;
        }
        if (introduction != null) {
            this.introduction = introduction;
        }
        if (operatingHours != null) {
            this.operatingHours = operatingHours;
        }
        if (storeCategory != null) {
            this.storeCategory = storeCategory;
        }
    }

    // 연관관계 편의 메서드
    public void addImage(StoreImage image) {
        this.images.add(image);
    }

    public void removeImage(StoreImage image) {
        this.images.remove(image);
    }
}

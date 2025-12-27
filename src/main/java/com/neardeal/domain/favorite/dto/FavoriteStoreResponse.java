package com.neardeal.domain.favorite.dto;

import com.neardeal.domain.store.entity.Store;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FavoriteStoreResponse {

    private Long storeId;
    private String name;
    private String address;
    private String storeCategory;
    private String imageUrl; // 대표이미지

    public static FavoriteStoreResponse from(Store store) {
        return FavoriteStoreResponse.builder()
                .storeId(store.getId())
                .name(store.getName())
                .address(store.getAddress())
                .storeCategory(store.getStoreCategory().toString())
                .build();
    }
}

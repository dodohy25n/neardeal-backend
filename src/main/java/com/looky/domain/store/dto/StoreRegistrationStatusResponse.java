package com.looky.domain.store.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StoreRegistrationStatusResponse {
    private boolean hasMenu;
    private boolean hasStoreInfo;

    public static StoreRegistrationStatusResponse of(boolean hasMenu, boolean hasStoreInfo) {
        return StoreRegistrationStatusResponse.builder()
                .hasMenu(hasMenu)
                .hasStoreInfo(hasStoreInfo)
                .build();
    }
}

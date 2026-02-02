package com.looky.domain.item.entity;

import com.looky.common.entity.BaseEntity;
import com.looky.domain.store.entity.Store;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "item_category")
public class ItemCategory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_category_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @Column(nullable = false)
    private String name;

    @Builder
    public ItemCategory(Store store, String name) {
        this.store = store;
        this.name = name;
    }

    public void updateName(String name) {
        this.name = name;
    }
}

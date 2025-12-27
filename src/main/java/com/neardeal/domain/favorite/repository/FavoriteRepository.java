package com.neardeal.domain.favorite.repository;

import com.neardeal.domain.favorite.entity.FavoriteStore;
import com.neardeal.domain.store.entity.Store;
import com.neardeal.domain.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<FavoriteStore, Long> {

    boolean existsByUserAndStore(User user, Store store);

    void deleteByUserAndStore(User user, Store store);

    long countByStore(Store store);

    Page<FavoriteStore> findByUser(User user, Pageable pageable);
}

package com.neardeal.domain.item.service;

import com.neardeal.common.exception.CustomException;
import com.neardeal.common.exception.ErrorCode;
import com.neardeal.domain.item.dto.CreateItemRequest;
import com.neardeal.domain.item.dto.ItemResponse;
import com.neardeal.domain.item.dto.UpdateItemRequest;
import com.neardeal.domain.item.entity.Item;
import com.neardeal.domain.item.repository.ItemRepository;
import com.neardeal.domain.store.entity.Store;
import com.neardeal.domain.store.repository.StoreRepository;
import com.neardeal.domain.user.entity.User;
import com.neardeal.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRepository itemRepository;
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long createItem(Long storeId, User user, CreateItemRequest request) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new CustomException(ErrorCode.RESOURCE_NOT_FOUND, "가게를 찾을 수 없습니다."));

        validateStoreOwner(store, user);

        Item item = request.toEntity(store);
        Item savedItem = itemRepository.save(item);
        return savedItem.getId();
    }

    public List<ItemResponse> getItems(Long storeId) {
        storeRepository.findById(storeId)
                .orElseThrow(() -> new CustomException(ErrorCode.RESOURCE_NOT_FOUND, "가게를 찾을 수 없습니다."));

        return itemRepository.findByStoreId(storeId).stream()
                .map(ItemResponse::from)
                .collect(Collectors.toList());
    }

    public ItemResponse getItem(Long itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new CustomException(ErrorCode.RESOURCE_NOT_FOUND, "상품을 찾을 수 없습니다."));
        return ItemResponse.from(item);
    }

    @Transactional
    public void updateItem(Long itemId, User user, UpdateItemRequest request) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new CustomException(ErrorCode.RESOURCE_NOT_FOUND, "상품을 찾을 수 없습니다."));

        validateStoreOwner(item.getStore(), user);

        item.updateItem(
                request.getName(),
                request.getPrice(),
                request.getDescription(),
                request.getImageUrl(),
                request.getIsSoldOut());
    }

    @Transactional
    public void deleteItem(Long itemId, User user) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new CustomException(ErrorCode.RESOURCE_NOT_FOUND, "상품을 찾을 수 없습니다."));

        validateStoreOwner(item.getStore(), user);

        itemRepository.delete(item);
    }

    private void validateStoreOwner(Store store, User user) {
        User owner = userRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        if (!Objects.equals(store.getUser().getId(), owner.getId())) {
            throw new CustomException(ErrorCode.FORBIDDEN, "가게 주인이 아닙니다.");
        }
    }
}

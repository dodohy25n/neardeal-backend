package com.looky.domain.admin.service;

import com.looky.common.exception.CustomException;
import com.looky.common.exception.ErrorCode;
import com.looky.common.response.PageResponse;
import com.looky.domain.admin.dto.UserResponse;
import com.looky.domain.admin.dto.UserRoleUpdateRequest;
import com.looky.domain.user.entity.User;
import com.looky.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserManageService {

    private final UserRepository userRepository;

    // 전체 사용자 조회
    @Transactional(readOnly = true)
    public PageResponse<UserResponse> getAllUsers(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        Page<UserResponse> userResponses = users.map(UserResponse::from);
        return PageResponse.from(userResponses);
    }

    // 사용자 권한 수정
    @Transactional
    public void updateUserRole(Long userId, UserRoleUpdateRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        user.changeRole(request.getRole());
    }
}

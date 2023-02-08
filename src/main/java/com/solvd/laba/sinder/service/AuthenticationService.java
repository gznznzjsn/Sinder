package com.solvd.laba.sinder.service;

import com.solvd.laba.sinder.domain.user.AuthEntity;

public interface AuthenticationService {

    void register(AuthEntity authEntity);

    AuthEntity login(AuthEntity authEntity);

    AuthEntity refresh(AuthEntity authEntity);

    AuthEntity enable(AuthEntity authEntity);

    void requestPasswordRefresh(Long authEntity);

    AuthEntity refreshPassword(AuthEntity authEntity);

    AuthEntity updatePassword(Long userId, AuthEntity authEntity);

}

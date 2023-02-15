package com.solvd.laba.sinder.service;

import com.solvd.laba.sinder.domain.AuthEntity;

public interface AuthenticationService {

    void register(AuthEntity authEntity);

    AuthEntity login(AuthEntity authEntity);

    AuthEntity refresh(AuthEntity authEntity);

    AuthEntity enable(AuthEntity authEntity);

    void requestPasswordRefresh(AuthEntity authEntity);

    AuthEntity refreshPassword(AuthEntity authEntity);

    AuthEntity updatePassword(Long userId, AuthEntity authEntity);

}

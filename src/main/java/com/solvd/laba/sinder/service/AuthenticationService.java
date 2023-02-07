package com.solvd.laba.sinder.service;

import com.solvd.laba.sinder.domain.user.AuthEntity;

public interface AuthenticationService {

    void register(AuthEntity authEntity);

    AuthEntity login(AuthEntity authEntity);

    void requestPasswordRefresh(AuthEntity authEntity);

    AuthEntity refreshPassword(AuthEntity authEntity);

    AuthEntity updatePassword(AuthEntity authEntity);

}

package com.slovd.laba.sinder.service;

import com.slovd.laba.sinder.domain.User;

public interface AuthenticationService {

    void register(AuthEntity authEntity);

    AuthEntity login(AuthEntity authEntity);

    void requestPasswordRefresh(AuthEntity authEntity);

    AuthEntity refreshPassword(AuthEntity authEntity);

    AuthEntity updatePassword(AuthEntity authEntity);

}

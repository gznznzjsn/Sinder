package com.solvd.laba.sinder.service.impl;

import com.solvd.laba.sinder.domain.user.AuthEntity;
import com.solvd.laba.sinder.service.AuthenticationService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Override
    public void register(AuthEntity authEntity) {

    }

    @Override
    public AuthEntity login(AuthEntity authEntity) {
        return null;
    }

    @Override
    public AuthEntity refresh(AuthEntity authEntity) {
        return null;
    }

    @Override
    public AuthEntity enable(AuthEntity authEntity) {
        return null;
    }

    @Override
    public void requestPasswordRefresh(Long authEntity) {

    }

    @Override
    public AuthEntity refreshPassword(AuthEntity authEntity) {
        return null;
    }

    @Override
    public AuthEntity updatePassword(Long userId, AuthEntity authEntity) {
        return null;
    }

}

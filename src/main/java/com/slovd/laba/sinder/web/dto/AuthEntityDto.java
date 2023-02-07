package com.slovd.laba.sinder.web.dto;

import com.slovd.laba.sinder.web.dto.group.*;
import jakarta.validation.constraints.NotNull;

public record AuthEntityDto(

        @NotNull(groups = {OnRegister.class})
        String name,

        @NotNull(groups = {OnRegister.class})
        String surname,

        @NotNull(groups = {OnRegister.class, OnLogin.class})
        String email,

        @NotNull(groups = {OnRegister.class, OnLogin.class, OnPasswordRefresh.class, OnUpdatePassword.class})
        String password,

        @NotNull(groups = {OnUpdatePassword.class})
        String newPassword,

        String accessToken,

        @NotNull(groups = {OnRefresh.class})
        String refreshToken,

        String enableToken,

        @NotNull(groups = {OnPasswordRefresh.class})
        String passwordRefreshToken

) {
}

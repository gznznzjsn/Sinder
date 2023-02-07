package com.solvd.laba.sinder.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthEntity {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String newPassword;
    private String accessToken;
    private String refreshToken;
    private String enableToken;
    private String passwordRefreshToken;

}

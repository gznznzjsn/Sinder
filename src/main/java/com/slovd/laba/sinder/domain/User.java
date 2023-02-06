package com.slovd.laba.sinder.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.awt.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Data
public class User implements UserDetails {

    private Long id;
    private String name;
    private String surname;
    private String password;
    private Gender gender;
    private Point geolocation;
    private Integer age;
    private String description;
    private List<String> photos;
    private List<LocalDate> partyDates;
    private Integer phoneNumber;
    private String instagramLink;
    private String facebookLink;
    private PairPreference pairPreference;
    private boolean enabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }
}

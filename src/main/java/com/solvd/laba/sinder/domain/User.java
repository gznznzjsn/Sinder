package com.solvd.laba.sinder.domain;

import com.solvd.laba.sinder.domain.pairs.PairPreference;
import com.solvd.laba.sinder.domain.parties.PartyPreference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name", nullable = false, length = 50)
    private String name;

    @Column(name = "user_email",nullable = false, unique = true, length = 50)
    private String email;

    @Column(name = "user_surname",nullable = false, length = 50)
    private String surname;

    @Column(name = "user_password",nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_gender")
    private Gender gender;

    @Column(name = "user_age")
    private Integer age;

    @Column(name = "user_description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_pair_preference_id")
    private PairPreference pairPreference;

    @ManyToOne
    @JoinColumn(name = "user_party_preference_id")
    private PartyPreference partyPreference;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "latitude", column = @Column(name = "user_latitude")),
            @AttributeOverride(name = "longitude", column = @Column(name = "user_longitude"))
    })
    private Point geolocation;

    @ElementCollection
    @CollectionTable(name = "users_photos", joinColumns = @JoinColumn(name = "users_photos_user_id"))
    private List<String> photos;

    @Column(name = "phone_number")
    private Integer phoneNumber;

    @Column(name = "instagram_link")
    private String instagramLink;

    @Column(name = "facebook_link")
    private String facebookLink;

    @Column(nullable = false)
    private Boolean enabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

}

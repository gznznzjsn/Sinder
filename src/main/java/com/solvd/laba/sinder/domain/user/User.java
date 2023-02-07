package com.solvd.laba.sinder.domain.user;

import com.solvd.laba.sinder.domain.Point;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
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
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(nullable = false, length = 50)
    private String surname;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "pair_preference_id", nullable = false)
    private PairPreference pairPreference;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "latitude", column = @Column(name = "latitude")),
            @AttributeOverride(name = "longitude", column = @Column(name = "longitude"))
    })
    private Point geolocation;

    @ElementCollection
    @CollectionTable(name = "users_photos", joinColumns = @JoinColumn(name = "user_id", nullable = false))
    private List<String> photos;

    @ElementCollection
    @CollectionTable(name = "users_party_dates", joinColumns = @JoinColumn(name = "user_id", nullable = false))
    private List<LocalDate> partyDates;

    @Column(name = "phone_number", nullable = false)
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

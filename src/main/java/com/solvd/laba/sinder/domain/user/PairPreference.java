package com.solvd.laba.sinder.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pair_preferences")
public class PairPreference {

    @Id
    @GeneratedValue
    private Long id;

    @ElementCollection(targetClass = Gender.class)
    @CollectionTable(name = "pair_preferences_genders", joinColumns = @JoinColumn(name = "pair_preference_id", nullable = false))
    @Enumerated(EnumType.STRING)
    private Set<Gender> genders;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Goal goal;

    @Column(name = "min_age", nullable = false)
    private Integer minAge;

    @Column(name = "max_age",nullable = false)
    private Integer maxAge;

    @Column(nullable = false)
    private Integer radius;

}

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
    @Column(name = "pair_preference_id")
    private Long id;

    @ElementCollection(targetClass = Gender.class)
    @CollectionTable(name = "pair_preferences_genders", joinColumns = @JoinColumn(name = "pair_preferences_genders_pair_preference_id", nullable = false))
    @Enumerated(EnumType.STRING)
    private Set<Gender> genders;

    @Enumerated(EnumType.STRING)
    @Column(name = "pair_preference_goal", nullable = false)
    private Goal goal;

    @Column(name = "pair_preference_min_age", nullable = false)
    private Integer minAge;

    @Column(name = "pair_preference_max_age",nullable = false)
    private Integer maxAge;

    @Column(nullable = false)
    private Integer radius;

}

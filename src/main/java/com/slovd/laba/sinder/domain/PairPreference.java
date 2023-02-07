package com.slovd.laba.sinder.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PairPreference {

    private Long id;
    private Set<Gender> genders;
    private Goal goal;
    private Integer minAge;
    private Integer maxAge;
    private Integer radius;

}

package com.slovd.laba.sinder.domain;

import lombok.Data;

import java.util.Set;

@Data
public class PairPreference {

    private Long id;
    private Set<Gender> genders;
    private Integer minAge;
    private Integer maxAge;
    private Goal goal;
    private Integer radius;

    public enum PairStatus {

        REQUESTED,
        APPROVED,
        REJECTED

    }

}

package com.slovd.laba.sinder.domain;

import lombok.Data;

import java.awt.*;
import java.time.LocalDate;
import java.util.List;

@Data
public class Party {

    private Long id;
    private Long creatorId;
    private String name;
    private String description;
    private Point geolocation;
    private List<String> photos;
    private LocalDate date;
    private String dressCode;
    private Integer capacity;
    private Integer minAge;
    private Integer maxAge;
    private boolean published;

    public enum PartyStatus {

        REQUESTED,
        INVITED,
        APPROVED,
        REJECTED

    }

}

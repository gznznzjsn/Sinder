package com.slovd.laba.sinder.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Party {

    private Long id;
    private User creator;
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

}

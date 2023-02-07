package com.solvd.laba.sinder.domain;

import com.solvd.laba.sinder.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "parties")
public class Party {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "creator_id", nullable = false)
    private User creator;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDate date;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "latitude", column = @Column(name = "latitude")),
            @AttributeOverride(name = "longitude", column = @Column(name = "longitude"))
    })
    private Point geolocation;

    @ElementCollection
    @CollectionTable(name = "parties_photos", joinColumns = @JoinColumn(name = "party_id", nullable = false))
    private List<String> photos;

    @Column(name = "dress_code", nullable = false, length = 50)
    private String dressCode;

    @Column(nullable = false)
    private Integer capacity;

    @Column(name = "min_age", nullable = false)
    private Integer minAge;

    @Column(name = "max_age",nullable = false)
    private Integer maxAge;

    @Column(nullable = false)
    private Boolean published;

}

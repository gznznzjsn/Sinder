package com.solvd.laba.sinder.domain.parties;

import com.solvd.laba.sinder.domain.Point;
import com.solvd.laba.sinder.domain.User;
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
    @Column(name = "party_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "party_creator_id", nullable = false)
    private User creator;

    @Column(name = "party_name", nullable = false, length = 50)
    private String name;

    @Column(name = "party_description", nullable = false)
    private String description;

    @Column(name = "party_date", nullable = false)
    private LocalDate date;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "latitude", column = @Column(name = "party_latitude")),
            @AttributeOverride(name = "longitude", column = @Column(name = "party_longitude"))
    })
    private Point geolocation;

    @ElementCollection
    @CollectionTable(name = "parties_photos", joinColumns = @JoinColumn(name = "parties_photos_party_id", nullable = false))
    private List<String> photos;

    @Column(name = "party_dress_code", nullable = false, length = 50)
    private String dressCode;

    @Column(name = "party_capacity", nullable = false)
    private Integer capacity;

    @Column(name = "party_min_age", nullable = false)
    private Integer minAge;

    @Column(name = "party_max_age",nullable = false)
    private Integer maxAge;

    @Column(nullable = false)
    private Boolean published;

}

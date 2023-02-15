package com.solvd.laba.sinder.domain.parties;

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
@Table(name = "party_preferences")
public class PartyPreference {

    @Id
    @GeneratedValue
    @Column(name = "party_preference_id")
    private Long id;

    @ElementCollection
    @CollectionTable(name = "party_preferences_party_dates", joinColumns = @JoinColumn(name = "party_preferences_party_dates_party_preference_id", nullable = false))
    private List<LocalDate> partyDates;

}

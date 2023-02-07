package com.solvd.laba.sinder.domain.partymatch;

import com.solvd.laba.sinder.domain.Party;
import com.solvd.laba.sinder.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "party_matches")
public class PartyMatch {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PartyMatchStatus status;

    @ManyToOne
    @JoinColumn(name = "guest_id", nullable = false)
    private User guest;

    @ManyToOne
    @JoinColumn(name = "party_id", nullable = false)
    private Party party;

}

package com.solvd.laba.sinder.domain.pairmatch;

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
@Table(name = "pair_matches")
public class PairMatch {

    @Id
    @GeneratedValue
    @Column(name = "pair_match_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "pair_match_status", nullable = false)
    private PairMatchStatus status;

    @ManyToOne
    @JoinColumn(name = "pair_match_sender_id", nullable = false)
    private User sender;

    @ManyToOne
    @JoinColumn(name = "pair_match_receiver_id", nullable = false)
    private User receiver;

}

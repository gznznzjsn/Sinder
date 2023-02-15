package com.solvd.laba.sinder.persistence;

import com.solvd.laba.sinder.domain.parties.PartyMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartyMatchRepository extends JpaRepository<PartyMatch, Long> {

    Optional<PartyMatch> findByGuestIdAndPartyId(Long guestId, Long partyId);

    Boolean existsByGuestIdAndPartyId(Long guestId, Long partyId);

}

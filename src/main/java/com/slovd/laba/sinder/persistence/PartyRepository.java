package com.slovd.laba.sinder.persistence;

import com.slovd.laba.sinder.domain.Party;
import com.slovd.laba.sinder.domain.User;

import java.util.List;

public interface PartyRepository {

    List<Party> findPartiesFor(Long userId);

    Party findById(Long partyId);

    void requestParty(Long guestId, Long partyId);

    void skipParty(Long guestId, Long partyId);

    void create(Party party);

    void update(Party party);

    void delete(Long partyId);

}

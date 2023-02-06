package com.slovd.laba.sinder.persistence;

import com.slovd.laba.sinder.domain.Party;
import com.slovd.laba.sinder.domain.User;
import jakarta.servlet.http.Part;

import java.util.List;

public interface PartyRepository {

    List<Party> findAppropriate(User user);

    Party findById(Long partyId);

    void inviteGuest(Long partyId, Long guestId);

    void skipGuest(Long partyId, Long guestId);

    void create(Party party);

    void update(Party party);

    void delete(Long partyId);

}

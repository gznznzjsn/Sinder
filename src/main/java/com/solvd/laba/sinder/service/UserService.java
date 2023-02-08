package com.solvd.laba.sinder.service;

import com.solvd.laba.sinder.domain.pairmatch.PairMatch;
import com.solvd.laba.sinder.domain.partymatch.PartyMatch;
import com.solvd.laba.sinder.domain.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<User> retrievePairsFor(Long userId, Pageable pageable);

    Page<User> retrieveGuestsFor(Long partyId, Pageable pageable);

    User retrieveById(Long userId);

    PairMatch skipPair(Long userId, Long pairId);

    PairMatch likePair(Long userId, Long pairId);

    PartyMatch inviteGuest(Long partyId, Long guestId);

    PartyMatch skipGuest(Long partyId, Long guestId);

    User create(User user);

    User update(User user);

    void delete(Long userId);

}

package com.slovd.laba.sinder.service;

import com.slovd.laba.sinder.domain.Party;
import com.slovd.laba.sinder.domain.User;

import java.util.List;

public interface UserService {

    User create(User user);

    User update(User user);

    void delete(Long userId);

    User retrieveById(Long userId);

    void skipPair(Long userId, Long pairId);

    void likePair(Long userId, Long pairId);

    List<User> retrievePairsFor(Long userId);

    List<Party> retrievePartiesFor(Long userId);

    List<User> retrieveGuestsFor(Long partyId);

    void inviteGuest(Long partyId, Long guestId);

    void skipGuest(Long partyId, Long guestId);

}

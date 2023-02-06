package com.slovd.laba.sinder.persistence;

import com.slovd.laba.sinder.domain.Party;
import com.slovd.laba.sinder.domain.User;

import java.util.List;

public interface UserRepository {

    List<User> findPairsFor(User user);

    List<User> findGuestsFor(Party party);

    User findById(Long userId);

    boolean isExist(String email);

    void likePair(Long userId, Long pairId);

    void skipPair(Long userId, Long pairId);

    void requestParty(Long guestId, Long partyId);

    void skipParty(Long guestId, Long partyId);

    void create(User user);

    void update(User user);

    void delete(Long userId);

}

package com.solvd.laba.sinder.service;

import com.solvd.laba.sinder.domain.pairmatch.PairMatch;

public interface PairMatchService {

    PairMatch retrieveById(Long pairMatchId);

    PairMatch retrieveBySenderIdAndReceiverId(Long userId, Long pairId);

    Boolean isExist(Long userId, Long pairId); //todo remove from interface ???

    PairMatch skipPair(Long userId, Long pairId);

    PairMatch likePair(Long userId, Long pairId);

    PairMatch create(PairMatch pairMatch);

    PairMatch update(PairMatch pairMatch);

}

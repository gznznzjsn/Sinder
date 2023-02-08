package com.solvd.laba.sinder.service;

import com.solvd.laba.sinder.domain.pairmatch.PairMatch;

public interface PairMatchService {

    PairMatch likePair(Long userId, Long pairId);

    PairMatch skipPair(Long userId, Long pairId);
}

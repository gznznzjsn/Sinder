package com.solvd.laba.sinder.service.impl;

import com.solvd.laba.sinder.domain.exception.IllegalActionException;
import com.solvd.laba.sinder.domain.exception.ResourceNotFoundException;
import com.solvd.laba.sinder.domain.pairmatch.PairMatch;
import com.solvd.laba.sinder.domain.pairmatch.PairMatchStatus;
import com.solvd.laba.sinder.domain.user.User;
import com.solvd.laba.sinder.persistence.PairMatchRepository;
import com.solvd.laba.sinder.service.PairMatchService;
import com.solvd.laba.sinder.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PairMatchServiceImpl implements PairMatchService {

    private final PairMatchRepository pairMatchRepository;
    private final UserService userService;

    @Override
    public PairMatch skipPair(Long userId, Long pairId) {
        User user = userService.retrieveById(userId);
        User pair = userService.retrieveById(pairId);
        if (isExist(userId, pairId)) {
            throw new IllegalActionException(""); //todo message
        }
        if (isExist(pairId, userId)) {
            PairMatch pairMatch = retrieveBySenderIdAndReceiverId(pairId, userId);
            if (pairMatch.getStatus().equals(PairMatchStatus.REQUESTED)) {
                pairMatch.setStatus(PairMatchStatus.REJECTED);
                return update(pairMatch);
            } else {
                throw new IllegalActionException(""); //todo message
            }
        }
        PairMatch pairMatch = PairMatch.builder()
                .status(PairMatchStatus.REJECTED)
                .sender(user)
                .receiver(pair)
                .build();
        return create(pairMatch);
    }

    @Override
    public PairMatch likePair(Long userId, Long pairId) {
        User user = userService.retrieveById(userId);
        User pair = userService.retrieveById(pairId);
        if (isExist(userId, pairId)) {
            throw new IllegalActionException(""); //todo message
        }
        if (isExist(pairId, userId)) {
            PairMatch pairMatch = retrieveBySenderIdAndReceiverId(pairId, userId);
            if (pairMatch.getStatus().equals(PairMatchStatus.REQUESTED)) {
                pairMatch.setStatus(PairMatchStatus.APPROVED);
                return update(pairMatch);
            } else {
                throw new IllegalActionException(""); //todo message
            }
        }
        PairMatch pairMatch = PairMatch.builder()
                .status(PairMatchStatus.REQUESTED)
                .sender(user)
                .receiver(pair)
                .build();
        return create(pairMatch);
    }

    @Override
    public PairMatch create(PairMatch pairMatch) {
        return pairMatchRepository.save(pairMatch);
    }

    @Override
    public PairMatch update(PairMatch pairMatch) {
        PairMatch foundPairMatch = retrieveById(pairMatch.getId());
        foundPairMatch.setStatus(pairMatch.getStatus());
        return pairMatchRepository.save(foundPairMatch);
    }

    @Override
    public Boolean isExist(Long userId, Long pairId) {
        return pairMatchRepository.existsBySenderIdAndReceiverId(userId, pairId);
    }

    @Override
    public PairMatch retrieveById(Long pairMatchId) {
        return pairMatchRepository.findById(pairMatchId)
                .orElseThrow(() -> new ResourceNotFoundException("PairMatch with id = " + pairMatchId + " not found!"));

    }

    @Override
    public PairMatch retrieveBySenderIdAndReceiverId(Long userId, Long pairId) {
        return pairMatchRepository.findBySenderIdAndReceiverId(userId, pairId)
                .orElseThrow(() -> new ResourceNotFoundException("PairMatch with sender's id = " + userId + " and receiver's id = " + pairId + " not found!"));

    }

}

package com.solvd.laba.sinder.service.impl;

import com.solvd.laba.sinder.domain.exception.ResourceAlreadyExistsException;
import com.solvd.laba.sinder.domain.exception.ResourceNotFoundException;
import com.solvd.laba.sinder.domain.user.PairPreference;
import com.solvd.laba.sinder.domain.user.PartyPreference;
import com.solvd.laba.sinder.domain.user.User;
import com.solvd.laba.sinder.persistence.UserRepository;
import com.solvd.laba.sinder.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Page<User> retrievePairsFor(Long userId, Pageable pageable) {
        return userRepository.findPairsFor(userId,pageable);
    }

    @Override
    public Page<User> retrieveGuestsFor(Long partyId, Pageable pageable) {
        return userRepository.findGuestsFor(partyId, pageable);
    }

    @Override
    public User retrieveById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with id = " + userId + " not found!"));
    }

    @Override
    @Transactional
    public User create(User user) {
        if (isExist(user.getEmail())) {
            throw new ResourceAlreadyExistsException("User with email = " + user.getEmail() + " already exists!");
        }
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User update(User user) {
        User foundUser = retrieveById(user.getId());
        foundUser.setName(user.getName());
        foundUser.setSurname(user.getSurname());
        foundUser.setGender(user.getGender());
        foundUser.setAge(user.getAge());
        foundUser.setDescription(user.getDescription());
        foundUser.setGender(user.getGender());
        foundUser.setPhotos(user.getPhotos());
        foundUser.setPhoneNumber(user.getPhoneNumber());
        foundUser.setInstagramLink(user.getInstagramLink());
        foundUser.setFacebookLink(user.getFacebookLink());
        PairPreference pairPreference = foundUser.getPairPreference();
        pairPreference.setGenders(user.getPairPreference().getGenders());
        pairPreference.setGoal(user.getPairPreference().getGoal());
        pairPreference.setMinAge(user.getPairPreference().getMinAge());
        pairPreference.setMaxAge(user.getPairPreference().getMaxAge());
        pairPreference.setRadius(user.getPairPreference().getRadius());
        foundUser.setPairPreference(pairPreference);
        PartyPreference partyPreference = foundUser.getPartyPreference();
        partyPreference.setPartyDates(user.getPartyPreference().getPartyDates());
        foundUser.setPartyPreference(partyPreference);
        return userRepository.save(foundUser);
    }

    @Override
    @Transactional
    public void delete(Long userId) {
        User user = retrieveById(userId);
        userRepository.delete(user);
    }

    @Override
    public Boolean isExist(String email) {
        return userRepository.existsByEmail(email);
    }

}

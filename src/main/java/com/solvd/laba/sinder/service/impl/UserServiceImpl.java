package com.solvd.laba.sinder.service.impl;

import com.solvd.laba.sinder.domain.Party;
import com.solvd.laba.sinder.domain.exception.ResourceAlreadyExistsException;
import com.solvd.laba.sinder.domain.exception.ResourceNotFoundException;
import com.solvd.laba.sinder.domain.user.PairPreference;
import com.solvd.laba.sinder.domain.user.User;
import com.solvd.laba.sinder.persistence.UserRepository;
import com.solvd.laba.sinder.service.PartyService;
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
    private final PartyService partyService;

    @Override
    public Page<User> retrievePairsFor(Long userId, Pageable pageable) {
        return null; //query
    }

    @Override
    public Page<User> retrieveGuestsFor(Long partyId, Pageable pageable) {
        Party party = partyService.retrieveById(partyId);
        return userRepository.findAllByPartyDates(party.getDate(), pageable);
    }

    @Override
    public User retrieveById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with id = " + userId + " not found!"));
    }

    @Override
    @Transactional
    public User create(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
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
        foundUser.setPartyDates(user.getPartyDates());
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
        return userRepository.save(foundUser);
    }

    @Override
    @Transactional
    public void delete(Long userId) {
        User user = retrieveById(userId);
        userRepository.delete(user);
    }
}

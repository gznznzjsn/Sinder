package com.solvd.laba.sinder.service.impl;

import com.solvd.laba.sinder.domain.exception.ResourceAlreadyExistsException;
import com.solvd.laba.sinder.domain.exception.ResourceNotFoundException;
import com.solvd.laba.sinder.domain.pairs.PairPreference;
import com.solvd.laba.sinder.domain.parties.PartyPreference;
import com.solvd.laba.sinder.domain.User;
import com.solvd.laba.sinder.persistence.UserRepository;
import com.solvd.laba.sinder.service.MinioService;
import com.solvd.laba.sinder.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MinioService minioService;

    @Override
    @Transactional(readOnly = true)
    public Page<User> retrievePairsFor(Long userId, Pageable pageable) {
        return userRepository.findPairsFor(userId, pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<User> retrieveGuestsFor(Long partyId, Pageable pageable) {
        return userRepository.findGuestsFor(partyId, pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public User retrieveById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with id = " + userId + " not found!"));
    }

    @Override
    @Transactional(readOnly = true)
    public User retrieveByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User with email = " + email + " not found!"));
    }

    @Override
    @Transactional
    public User enable(String email) {
        User user = retrieveByEmail(email);
        user.setEnabled(true);
        return userRepository.save(user);
    }

    @Override
    public User updatePassword(User user, String newPassword) {
        user.setPassword(newPassword);
        return userRepository.save(user);
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
    public User addPhoto(Long userId, MultipartFile photo) {
        User user = retrieveById(userId);
        List<String> photos = user.getPhotos();
        photos = minioService.uploadPhotos(userId, photo, photos);
        user.setPhotos(photos);
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deletePhoto(Long userId, String filename) {
        User user = retrieveById(userId);
        List<String> photos = user.getPhotos();
        photos = minioService.deletePhoto(userId, filename, photos);
        user.setPhotos(photos);
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }

    private Boolean isExist(String email) {
        return userRepository.existsByEmail(email);
    }

}

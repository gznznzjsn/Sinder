package com.solvd.laba.sinder.service;

import com.solvd.laba.sinder.domain.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

    Page<User> retrievePairsFor(Long userId, Pageable pageable);

    Page<User> retrieveGuestsFor(Long partyId, Pageable pageable);

    User retrieveById(Long userId);

    User retrieveByEmail(String email);

    User enable(String email);

    User updatePassword(User user, String newPassword);

    User create(User user);

    User update(User user);

    void delete(Long userId);

    User addPhoto(Long userId, MultipartFile photo);

    void deletePhoto(Long userId, String filename);

}

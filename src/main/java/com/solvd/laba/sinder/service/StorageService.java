package com.solvd.laba.sinder.service;

import com.solvd.laba.sinder.domain.Artifact;

public interface StorageService {

    String uploadPhoto(Long userId, Artifact photo);

    String deletePhoto(Long userId, String filename);

}

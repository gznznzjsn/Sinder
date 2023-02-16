package com.solvd.laba.sinder.service;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

    String uploadPhoto(Long userId, MultipartFile photo);

    String deletePhoto(Long userId, String filename);

}

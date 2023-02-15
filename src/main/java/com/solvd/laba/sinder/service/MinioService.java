package com.solvd.laba.sinder.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MinioService {

    List<String> uploadPhotos(Long userId, MultipartFile photo, List<String> photos);

    List<String> deletePhoto(Long userId, String filename, List<String> photos);

}

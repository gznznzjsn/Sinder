package com.solvd.laba.sinder.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MinioService {

//    String uploadPhoto(Long userId, MultipartFile photo);
//
//    String uploadThumbnail(Long userId, MultipartFile photo);

    List<String> uploadPhotos(Long userId, MultipartFile photo);

    void deletePhoto(Long userId, String path);

}

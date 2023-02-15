package com.solvd.laba.sinder.service.impl;

import com.solvd.laba.sinder.domain.exception.MinioException;
import com.solvd.laba.sinder.service.MinioService;
import com.solvd.laba.sinder.service.property.MinioProperty;
import io.minio.MinioClient;
import io.minio.RemoveObjectArgs;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.imgscalr.Scalr;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MinioServiceImpl implements MinioService {

    private final MinioClient minioClient;
    private final MinioProperty minioProperty;



//    @Override
//    public String uploadPhoto(Long userId, MultipartFile photo) {
//        try {
//            minioClient.putObject(PutObjectArgs.builder()
//                    .bucket(minioProperty.getBucket())
//                    .object(prepareName(userId, photo.getOriginalFilename()))
//                    .stream(photo.getInputStream(), photo.getSize(), -1)
//                    .build());
//            return prepareName(userId, photo.getOriginalFilename());
//        } catch (Exception e) {
//            throw new MinioException("Unable to upload photo, try again!");
//        }
//    }
//
//    @Override
//    public String uploadThumbnail(Long userId, MultipartFile photo) {
//        try {
//            minioClient.putObject(PutObjectArgs.builder()
//                    .bucket(minioProperty.getBucket())
//                    .object(prepareThumbnailName(userId, photo.getOriginalFilename()))
//                    .stream(generateThumbnail(photo), photo.getSize(), -1)
//                    .build());
//            return prepareThumbnailName(userId, photo.getOriginalFilename());
//        } catch (Exception e) {
//            throw  new MinioException("Unable to upload thumbnail, try again!");
//        }
//    }
//

    @Override
    public List<String> uploadPhotos(Long userId, MultipartFile photo) {
        return null;
    }

    @Override
    public void deletePhoto(Long userId, String path) {
        try {
            minioClient.removeObject(RemoveObjectArgs.builder()
                    .bucket(minioProperty.getBucket())
                    .object(path)
                    .build());
        } catch (Exception e) {
            throw new MinioException("Unable to delete photo, try again!");
        }
    }

//    private String prepareName(Long userId, String filename) {
//        return "users/" + userId + "/original/" + filename;
//    }
//
//    private String prepareThumbnailName(Long userId, String filename) {
//        return "users/" + userId + "/thumbnails/" + filename;
//    }

    @SneakyThrows
    private ByteArrayInputStream generateThumbnail(MultipartFile photo) {
        BufferedImage img = ImageIO.read(photo.getInputStream());
        BufferedImage thumbImg = Scalr.resize(img, Scalr.Method.AUTOMATIC, Scalr.Mode.AUTOMATIC, 400, Scalr.OP_ANTIALIAS);
        ByteArrayOutputStream thumbOutput = new ByteArrayOutputStream();
        ImageIO.write(thumbImg, photo.getContentType().split("/")[1], thumbOutput);
        return new ByteArrayInputStream(thumbOutput.toByteArray());
    }

}

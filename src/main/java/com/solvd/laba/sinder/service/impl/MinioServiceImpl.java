package com.solvd.laba.sinder.service.impl;

import com.solvd.laba.sinder.domain.exception.MinioException;
import com.solvd.laba.sinder.service.MinioService;
import com.solvd.laba.sinder.service.property.MinioProperty;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MinioServiceImpl implements MinioService {

    private final MinioClient minioClient;
    private final MinioProperty minioProperty;

    @Override
    public List<String> uploadPhotos(Long userId, MultipartFile photo, List<String> photos) {
        try {
            String path = "users/" + userId + "/original/" + photo.getOriginalFilename();
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(minioProperty.getBucket())
                    .object(path)
                    .stream(photo.getInputStream(), photo.getSize(), -1)
                    .build());
            photos.add(path);
            path = "users/" + userId + "/100/" + photo.getOriginalFilename();
            InputStream thumbnail = generateThumbnail(photo, 100);
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(minioProperty.getBucket())
                    .object(path)
                    .stream(thumbnail, thumbnail.available(), -1)
                    .build());
            photos.add(path);
            thumbnail.close();
            thumbnail = generateThumbnail(photo, 400);
            path = "users/" + userId + "/400/" + photo.getOriginalFilename();
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(minioProperty.getBucket())
                    .object(path)
                    .stream(thumbnail, thumbnail.available(), -1)
                    .build());
            photos.add(path);
            thumbnail.close();
            return photos;
        } catch (Exception e) {
            throw new MinioException("Unable to upload photo, try again!");
        }
    }

    @Override
    public List<String> deletePhoto(Long userId, String filename, List<String> photos) {
        try {
            String path = "users/" + userId + "/original/" + filename;
            minioClient.removeObject(RemoveObjectArgs.builder()
                    .bucket(minioProperty.getBucket())
                    .object(path)
                    .build());
            photos.remove(path);
            path = "users/" + userId + "/100/" + filename;
            minioClient.removeObject(RemoveObjectArgs.builder()
                    .bucket(minioProperty.getBucket())
                    .object(path)
                    .build());
            photos.remove(path);
            path = "users/" + userId + "/400/" + filename;
            minioClient.removeObject(RemoveObjectArgs.builder()
                    .bucket(minioProperty.getBucket())
                    .object(path)
                    .build());
            photos.remove(path);
            return photos;
        } catch (Exception e) {
            throw new MinioException("Unable to delete photo, try again!");
        }
    }

    @SneakyThrows //todo ioexception to controllerAdvice
    private InputStream generateThumbnail(MultipartFile photo, Integer height) {
        BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(photo.getBytes()));
        Thumbnails.Builder<BufferedImage> builder = Thumbnails.of(originalImage)
                .height(height)
                .outputFormat("jpeg");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        builder.toOutputStream(outputStream);
        return new ByteArrayInputStream(outputStream.toByteArray());
    }

}

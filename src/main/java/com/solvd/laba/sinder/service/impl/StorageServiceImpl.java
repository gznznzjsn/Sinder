package com.solvd.laba.sinder.service.impl;

import com.solvd.laba.sinder.domain.Artifact;
import com.solvd.laba.sinder.domain.exception.StorageException;
import com.solvd.laba.sinder.service.StorageService;
import com.solvd.laba.sinder.service.property.MinioProperty;
import io.minio.*;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.compress.utils.FileNameUtils;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

@Service
@RequiredArgsConstructor
public class StorageServiceImpl implements StorageService {

    private final MinioClient minioClient;
    private final MinioProperty minioProperty;

    @Override
    public String uploadPhoto(Long userId, Artifact photo) {
        try {
            createBucket();
            String path = "users/" + userId + "/100/" + photo.getFilename();
            savePhoto(path, generateThumbnail(photo, 100));
            path = "users/" + userId + "/400/" + photo.getFilename();
            savePhoto(path, generateThumbnail(photo, 400));
            path = "users/" + userId + "/original/" + photo.getFilename();
            savePhoto(path, new ByteArrayInputStream(photo.getBytes()));
            return path;
        } catch (Exception e) {
            e.printStackTrace();
            throw new StorageException("Unable to upload photo, try again!");
        }
    }

    @Override
    public String deletePhoto(Long userId, String filename) {
        try {
            String path = "users/" + userId + "/100/" + filename;
            removePhoto(path);
            path = "users/" + userId + "/400/" + filename;
            removePhoto(path);
            path = "users/" + userId + "/original/" + filename;
            removePhoto(path);
            return path;
        } catch (Exception e) {
            e.printStackTrace();
            throw new StorageException("Unable to delete photo, try again!");
        }
    }

    @SneakyThrows
    private void createBucket() {
        boolean found = minioClient.bucketExists(BucketExistsArgs.builder()
                .bucket(minioProperty.getBucket())
                .build());
        if (!found) {
            minioClient.makeBucket(MakeBucketArgs.builder()
                    .bucket(minioProperty.getBucket())
                    .build());
        }
    }

    @SneakyThrows
    private void savePhoto(String path, InputStream inputStream) {
        minioClient.putObject(PutObjectArgs.builder()
                .bucket(minioProperty.getBucket())
                .object(path)
                .stream(inputStream, inputStream.available(), -1)
                .build());
    }

    @SneakyThrows
    private void removePhoto(String path) {
        minioClient.removeObject(RemoveObjectArgs.builder()
                .bucket(minioProperty.getBucket())
                .object(path)
                .build());
    }

    @SneakyThrows
    private InputStream generateThumbnail(Artifact photo, Integer height) {
        String extension = FileNameUtils.getExtension(photo.getFilename());
        BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(photo.getBytes()));
        Thumbnails.Builder<BufferedImage> builder = Thumbnails.of(originalImage)
                .height(height)
                .outputFormat(extension);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        builder.toOutputStream(outputStream);
        return new ByteArrayInputStream(outputStream.toByteArray());
    }

}

package com.solvd.laba.sinder.service.config;

import com.solvd.laba.sinder.domain.exception.StorageException;
import com.solvd.laba.sinder.service.property.MinioProperty;
import io.minio.MinioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ServiceConfig {

    private final MinioProperty minioProperty;

    @Bean
    public MinioClient minioClient() {
        try {
            return MinioClient.builder()
                    .endpoint(minioProperty.getUrl())
                    .credentials(minioProperty.getAccessKey(), minioProperty.getSecretKey())
                    .build();
        } catch (Exception e) {
            throw new StorageException("Unable to connect to minio!");
        }
    }

}

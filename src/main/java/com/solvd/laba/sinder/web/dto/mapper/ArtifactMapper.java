package com.solvd.laba.sinder.web.dto.mapper;

import com.solvd.laba.sinder.domain.Artifact;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Mapper(componentModel = "spring")
public interface ArtifactMapper {

    @Mapping(target = "filename", expression = "java(mapFilename(multipartFile.getOriginalFilename()))")
    @Mapping(target = "bytes", expression = "java(mapBytes(multipartFile.getBytes()))")
    Artifact toEntity(MultipartFile multipartFile) throws IOException;

    default String mapFilename(String filename) {
        return filename;
    }

    default byte[] mapBytes(byte[] bytes){
        return bytes;
    }

}

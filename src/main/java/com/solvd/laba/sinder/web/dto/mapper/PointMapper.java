package com.solvd.laba.sinder.web.dto.mapper;

import com.solvd.laba.sinder.domain.Point;
import com.solvd.laba.sinder.web.dto.PointDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PointMapper {

    Point toEntity(PointDto dto);

    PointDto toDto(Point entity);

}

package com.slovd.laba.sinder.web.dto.mapper;

import com.slovd.laba.sinder.domain.Attachment;
import com.slovd.laba.sinder.web.dto.AttachmentDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")//, uses = {EmployeeMapper.class, TaskListMapper.class})
public interface AttachmentMapper {

    Attachment toEntity(AttachmentDto dto);

    AttachmentDto toDto(Attachment entity);

}

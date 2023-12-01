package com.file.managemnet.app.mapper;

import com.file.managemnet.base.mapper.DtoMapper;
import com.file.managemnet.app.persistence.domain.ImageEntity;
import com.file.managemnet.app.data.ImageResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImageMapper extends DtoMapper<ImageResponse, ImageEntity> {
}

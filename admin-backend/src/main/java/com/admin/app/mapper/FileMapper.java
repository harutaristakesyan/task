package com.admin.app.mapper;

import com.admin.app.data.FileRequest;
import com.admin.app.data.FileResponse;
import com.admin.app.persistence.domain.FileDomain;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface FileMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "originalId", source = "id")
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "updated", ignore = true)
    FileDomain toEntity(FileRequest request);

    @Mapping(target = "id", source = "originalId")
    @Mapping(target = "url", source = "id", qualifiedByName = "collectUrls")
    FileResponse toResponse(FileDomain entity, @Context String imageUrl);

    @Named("collectUrls")
    default String collectUrls(final UUID id, @Context final String imageUrl) {
        return imageUrl + id.toString();
    }
}

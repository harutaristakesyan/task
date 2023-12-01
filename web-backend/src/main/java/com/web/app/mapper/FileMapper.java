package com.web.app.mapper;

import com.web.app.data.FileResponse;
import com.web.app.persistence.domain.FileDomain;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface FileMapper {


    @Mapping(target = "url", source = "id", qualifiedByName = "collectUrls")
    FileResponse toResponse(FileDomain entity, @Context String imageUrl);

    @Named("collectUrls")
    default String collectUrls(final UUID id, @Context final String imageUrl) {
        if (id == null) {
            return null;
        }
        return imageUrl + id;
    }
}

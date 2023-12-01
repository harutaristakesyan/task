package com.i18n.translation.mapper;

import com.i18n.base.mapper.DtoMapper;
import com.i18n.base.mapper.DocumentMapper;
import com.i18n.translation.document.TranslationDocument;
import com.i18n.translation.model.TranslationRequest;
import com.i18n.translation.model.TranslationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TranslationMapper extends DtoMapper<TranslationResponse, TranslationDocument>,
        DocumentMapper<TranslationRequest, TranslationDocument> {


    @Override
    @Mapping(target = "id", ignore = true)
    TranslationDocument toDocument(TranslationRequest request);
}

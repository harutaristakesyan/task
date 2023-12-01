package com.web.core.mapper;

import com.web.app.persistence.domain.TextDomain;
import kafka.models.base.KafkaTextModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KafkaTextMapper extends DtoMapper<KafkaTextModel, TextDomain> {

}

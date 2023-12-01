package com.web.app.mapper;

import com.web.app.persistence.domain.MenuDomain;
import com.web.app.service.MenuService;
import com.web.core.mapper.KafkaModelMapper;
import com.web.core.mapper.KafkaTextMapper;
import kafka.models.menu.MenuKafkaModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper(componentModel = "spring", uses = {TextMapper.class, KafkaTextMapper.class})
public interface MenuMapper  extends KafkaModelMapper<MenuKafkaModel, MenuDomain> {

    @Mapping(target = "name", source = "names", qualifiedByName = "collectText")
    MenuService.MenuSearchResponse toSearchResponse(final MenuDomain entity);

}

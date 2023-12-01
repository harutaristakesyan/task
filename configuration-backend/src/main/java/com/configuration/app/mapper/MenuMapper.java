package com.configuration.app.mapper;

import com.configuration.app.persistence.domain.MenuDomain;
import com.configuration.app.service.MenuService;
import com.configuration.core.mapper.DtoMapper;
import com.configuration.core.mapper.EntityMapper;
import com.configuration.core.mapper.KafkaModelMapper;
import com.configuration.core.mapper.KafkaTextMapper;
import kafka.models.goods.GoodCategoryKafkaModel;
import kafka.models.menu.MenuKafkaModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper(componentModel = "spring", uses = {TextMapper.class, KafkaTextMapper.class})
public interface MenuMapper extends EntityMapper<MenuService.MenuRequest, MenuDomain>,
        DtoMapper<MenuService.MenuResponse, MenuDomain>,
        KafkaModelMapper<MenuKafkaModel, MenuDomain> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "updated", ignore = true)
    @Mapping(target = "children", source = "children", qualifiedByName = "uuidToMenuDomain")
    MenuDomain toEntity(MenuService.MenuRequest request);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "updated", ignore = true)
    @Mapping(target = "children", source = "children", qualifiedByName = "uuidToMenuDomain")
    void updateDomain(@MappingTarget MenuDomain target, MenuService.MenuRequest source);

    @Mapping(target = "created", ignore = true)
    @Mapping(target = "updated", ignore = true)
    @Mapping(target = "children", ignore = true)
    @Mapping(target = "iconName", ignore = true)
    @Mapping(target = "isNavBar", defaultValue = "false", ignore = true)
    MenuDomain fromKafkaModel(GoodCategoryKafkaModel kafkaModel);

    @Mapping(target = "name", source = "names", qualifiedByName = "collectText")
    MenuService.MenuSearchResponse toSearchResponse(final MenuDomain entity);

    @Named("uuidToMenuDomain")
    default MenuDomain uuidToMenuDomain(final UUID uuid) {
        MenuDomain menuDomain = new MenuDomain();
        menuDomain.setId(uuid); // Assuming MenuDomain has an "id" property of type UUID
        return menuDomain;
    }
}

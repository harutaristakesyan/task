package com.admin.app.mapper;

import com.admin.app.data.TextDto;
import com.admin.app.persistence.domain.TextDomain;
import com.admin.core.mapper.DtoMapper;
import com.admin.core.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface TextMapper extends EntityMapper<TextDto, TextDomain>, DtoMapper<TextDto, TextDomain> {

    @Named("collectText")
    default String collectText(final Set<TextDomain> texts) {
        final Locale currentLocale = LocaleContextHolder.getLocale();
        final String languageCode = currentLocale.getLanguage().toUpperCase(Locale.ROOT);
        return texts.stream()
                .filter(textDomain -> textDomain.getLangCode().equalsIgnoreCase(languageCode))
                .findFirst()
                .map(TextDomain::getText)
                .orElse("");
    }

}

package com.configuration.app.mapper;

import com.configuration.app.data.TextDto;
import com.configuration.app.persistence.domain.TextDomain;
import com.configuration.core.mapper.DtoMapper;
import com.configuration.core.mapper.EntityMapper;
import com.configuration.core.mapper.KafkaTextMapper;
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

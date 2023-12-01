package com.web.app.mapper;

import com.web.app.persistence.domain.TextDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.util.CollectionUtils;

import java.util.Locale;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface TextMapper {

    @Named("collectText")
    default String collectText(final Set<TextDomain> texts) {
        if (CollectionUtils.isEmpty(texts)) {
            return "";
        }
        final Locale currentLocale = LocaleContextHolder.getLocale();
        final String languageCode = currentLocale.getLanguage();
        return texts.stream()
                .filter(textDomain -> textDomain.getLangCode().equals(languageCode))
                .findFirst()
                .map(TextDomain::getText)
                .orElse("");
    }

}

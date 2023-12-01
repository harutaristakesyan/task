package com.i18n.translation.model;

import com.i18n.translation.enumaration.LanguageCode;

import java.util.Map;

public record TranslationResponse(String id, String applicationName, LanguageCode languageCode,
                                  Map<String, String> translations) {
}


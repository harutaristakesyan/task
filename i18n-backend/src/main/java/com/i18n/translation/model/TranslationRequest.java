package com.i18n.translation.model;

import java.util.Map;

public record TranslationRequest (String applicationName, String languageCode, Map<String, String> translations){
}

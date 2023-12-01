package com.i18n.translation.document;

import com.i18n.translation.enumaration.LanguageCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "c_translation")
public class TranslationDocument {

    @MongoId
    private String id;

    @Field("application_name")
    private String applicationName;

    @Field("language_code")
    private LanguageCode languageCode;

    @Field("translations")
    private Map<String, String> translations;
}

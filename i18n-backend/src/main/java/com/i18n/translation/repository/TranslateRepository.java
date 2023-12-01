package com.i18n.translation.repository;

import com.i18n.translation.document.TranslationDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranslateRepository extends MongoRepository<TranslationDocument, String> {
}

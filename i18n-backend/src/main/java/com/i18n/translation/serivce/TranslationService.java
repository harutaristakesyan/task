package com.i18n.translation.serivce;

import com.i18n.base.services.AddSupported;
import com.i18n.base.services.GetSupported;
import com.i18n.translation.model.TranslationRequest;
import com.i18n.translation.model.TranslationResponse;

public interface TranslationService extends AddSupported<TranslationRequest>, GetSupported<String, TranslationResponse> {
}

package com.web.cms.api;

import com.web.core.api.AllApi;
import com.web.core.config.SwagerProperties;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/questions")
@Tag(name = SwagerProperties.QUESTION_ANSWER_TITLE, description = SwagerProperties.QUESTION_ANSWER_DESCRIPTION)
public interface QuestionApi extends AllApi<ResponseEntity<?>> {
}

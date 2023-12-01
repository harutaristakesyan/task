package com.admin.app.api;

import com.admin.core.api.AllApi;
import com.admin.core.config.SwaggerProperties;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/questions")
@Tag(name = SwaggerProperties.QUESTION_ANSWER_TITLE, description = SwaggerProperties.QUESTION_ANSWER_DESCRIPTION)
public interface QuestionApi extends AllApi<ResponseEntity<?>> {
}

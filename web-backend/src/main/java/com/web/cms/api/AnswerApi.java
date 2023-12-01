package com.web.cms.api;


import com.web.core.config.SwagerProperties;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@RequestMapping("/answers")
@Tag(name = SwagerProperties.QUESTION_ANSWER_TITLE, description = SwagerProperties.QUESTION_ANSWER_DESCRIPTION)
public interface AnswerApi {

    @GetMapping("/by-question/{questionId}")
    @Operation(summary = "Retrieve all answers for a given question ID",
            description = "This endpoint retrieves a list of all answers for a given question ID.")
    ResponseEntity<?> allByQuestionId(
            @Parameter(description = "The ID of the question to retrieve answers for", required = true)
            @PathVariable("questionId") final UUID questionId
    );
}

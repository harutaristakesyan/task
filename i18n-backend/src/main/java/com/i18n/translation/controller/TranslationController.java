package com.i18n.translation.controller;


import com.i18n.base.response.BaseResponse;
import com.i18n.translation.model.TranslationRequest;
import com.i18n.translation.model.TranslationResponse;
import com.i18n.translation.serivce.TranslationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/translation")
public class TranslationController {

    private final TranslationService translationService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody final TranslationRequest request) {
        translationService.add(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse<TranslationResponse> get(@PathVariable String id) {
        return new BaseResponse<>(HttpStatus.OK.name(), "Translation", translationService.get(id));
    }

}


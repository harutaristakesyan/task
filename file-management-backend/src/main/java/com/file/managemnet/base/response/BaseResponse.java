package com.file.managemnet.base.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record BaseResponse<O>(String code, String message, O data) {
}

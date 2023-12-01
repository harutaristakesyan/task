package com.web.core.data;

public record BaseResponse<O>(int code, String messages, O data) {

}

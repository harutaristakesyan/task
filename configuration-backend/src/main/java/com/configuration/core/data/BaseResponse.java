package com.configuration.core.data;

public record BaseResponse<O>(int code, String messages, O data) {

}

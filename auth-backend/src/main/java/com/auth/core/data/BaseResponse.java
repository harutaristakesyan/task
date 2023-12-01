package com.auth.core.data;

public record BaseResponse<O>(String code, String message, O data) {
}

package com.admin.core.exception.handler;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class AdminExceptionHandler extends ResponseEntityExceptionHandler {


//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ExceptionHandler(EntityNotFoundException.class)
//    public ResponseEntity<BaseResponse<String>> handleNoSuchElementFoundException(final EntityNotFoundException exception) {
//        return ResponseEntity
//                .status(HttpStatus.NOT_FOUND)
//                .body(new BaseResponse<>(exception.getErrorCode(), exception.getMessage(), null));
//    }
}

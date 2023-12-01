package com.configuration.core.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ResponseAspect {

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void restControllerClass() {
    }

//    @Around("@annotation(org.springframework.web.bind.annotation.GetMapping)")
//    public Object get(ProceedingJoinPoint joinPoint) throws Throwable {
//        ApiResponse result = (ApiResponse) joinPoint.proceed();
//        var message = result.getMessage();
//        return new BaseResponse<>(message.getCode(), message.getMessage(), result);
//    }
//
//    @Around("@annotation(org.springframework.web.bind.annotation.PostMapping)")
//    public Object post(ProceedingJoinPoint joinPoint) throws Throwable {
//        ApiResponse result = (ApiResponse) joinPoint.proceed();
//        var message = result.getMessage();
//        return new BaseResponse<>(message.getCode(), message.getMessage(), result);
//    }
//
//    @Around("@annotation(org.springframework.web.bind.annotation.PutMapping)")
//    public Object put(ProceedingJoinPoint joinPoint) throws Throwable {
//        ApiResponse result = (ApiResponse) joinPoint.proceed();
//        var message = result.getMessage();
//        return new BaseResponse<>(message.getCode(), message.getMessage(), result);
//    }
//
//    @Around("@annotation(org.springframework.web.bind.annotation.PutMapping)")
//    public Object delete(ProceedingJoinPoint joinPoint) throws Throwable {
//        ApiResponse result = (ApiResponse) joinPoint.proceed();
//        var message = result.getMessage();
//        return new BaseResponse<>(message.getCode(), message.getMessage(), result);
//    }
}
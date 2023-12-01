package com.admin.core.util;

import com.admin.core.data.AbstractListResponse;
import com.admin.core.data.BaseResponse;
import com.admin.core.data.ResponseMessages;
import com.admin.core.data.Void;
import lombok.experimental.UtilityClass;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@UtilityClass
public class ResponseUtil {

    public static <O> AbstractListResponse<O> build(final long total, final List<O> items) {
        return new AbstractListResponse<>(total, items);
    }

    public static <O> ResponseEntity<BaseResponse<O>> ok(final O data) {
        return ResponseEntity.ok(new BaseResponse<>(200, "ok", data));
    }

    public static <O> ResponseEntity<BaseResponse<O>> created(final Void ignored) {
        return ResponseEntity.status(CREATED).body(new BaseResponse<>(201, "Created", null));
    }

    public static <O> ResponseEntity<BaseResponse<O>> noContent(final Void ignored) {
        return ResponseEntity.status(NO_CONTENT).body(new BaseResponse<>(204, "Updated", null));
    }
}

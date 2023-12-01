package com.admin.app.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface GoodsImportExportApi {

    @PostMapping("/import")
    ResponseEntity<?> importGoods(@RequestParam final MultipartFile file);
}

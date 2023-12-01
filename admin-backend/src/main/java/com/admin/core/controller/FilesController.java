package com.admin.core.controller;


import com.admin.core.client.file.service.FileService;
import com.admin.core.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/files")
public class FilesController {

    private final FileService fileService;

    @PostMapping
    public ResponseEntity<?> add(@RequestParam final MultipartFile file) {
        return ResponseUtil.ok(fileService.add(file));
    }
}

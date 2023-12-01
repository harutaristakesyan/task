package com.web.core.controller;

import com.web.core.client.file.service.FileService;
import com.web.core.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/files")
public class FilesController {

    private final FileService fileService;

    @PostMapping
    public ResponseEntity<?> add(@RequestPart MultipartFile file) {
        return ResponseUtil.ok(fileService.add(file));
    }
}

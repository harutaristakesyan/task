package com.file.managemnet.app.controller;

import com.file.managemnet.app.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/images")
public class ImageController {

    private final ImageService imageService;

    @GetMapping("/{id}")
    public ResponseEntity<Resource> getByImageName(@PathVariable UUID id) throws IOException {

        Resource file = imageService.get(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(Files.probeContentType(Path.of(file.getFile().getPath()))))
                .body(file);
    }

}

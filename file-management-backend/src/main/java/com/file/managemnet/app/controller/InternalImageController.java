package com.file.managemnet.app.controller;

import com.file.managemnet.app.data.ImageRequest;
import com.file.managemnet.app.data.ImageResponse;
import com.file.managemnet.app.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/internal/images")
public class InternalImageController {

    private final ImageService imageService;

    @PostMapping
    public ImageResponse add(@RequestBody ImageRequest imageRequest) {
        return imageService.add(imageRequest);
    }
}

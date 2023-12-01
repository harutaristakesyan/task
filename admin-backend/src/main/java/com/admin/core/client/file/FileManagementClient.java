package com.admin.core.client.file;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@FeignClient(value = "file-management", path = "/api/file-management")
public interface FileManagementClient {

    @PostMapping("/internal/images")
    ImageResponse saveImage(@RequestBody ImageRequest imageRequest);

    record ImageResponse(String imageUrl, UUID id, String originalName, String fileType) {
    }

    record ImageRequest(String appName, byte[] image, String imageName, long size, String type) {
    }

}

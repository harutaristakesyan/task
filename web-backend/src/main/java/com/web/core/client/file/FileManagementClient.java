package com.web.core.client.file;

import com.web.core.client.file.data.ImageRequest;
import com.web.core.client.file.data.ImageResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "file-management", path = "/api/file-management")
public interface FileManagementClient {

    @PostMapping("/internal/images")
    ImageResponse saveImage(@RequestBody ImageRequest imageRequest);
}

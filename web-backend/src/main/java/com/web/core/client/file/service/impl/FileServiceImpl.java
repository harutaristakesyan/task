package com.web.core.client.file.service.impl;

import com.web.core.client.file.FileManagementClient;
import com.web.core.client.file.data.ImageRequest;
import com.web.core.client.file.data.ImageResponse;
import com.web.core.client.file.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Log4j2
@RequiredArgsConstructor
class FileServiceImpl implements FileService {

    @Value("${spring.application.name}")
    private String appName;

    private final FileManagementClient fileManagementClient;

    @Override
    public FileResponse add(final MultipartFile request) {
        final ImageResponse imageResponse;
        try {
            imageResponse = fileManagementClient.saveImage(
                    new ImageRequest(
                            appName,
                            request.getBytes(),
                            request.getOriginalFilename(),
                            request.getSize(),
                            request.getContentType()
                    ));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new FileResponse(imageResponse.imageUrl(), imageResponse.id());
    }

}

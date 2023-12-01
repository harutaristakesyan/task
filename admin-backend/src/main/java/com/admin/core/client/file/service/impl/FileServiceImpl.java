package com.admin.core.client.file.service.impl;

import com.admin.core.client.file.FileManagementClient;
import com.admin.core.client.file.service.FileService;
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
        final FileManagementClient.ImageResponse imageResponse;
        try {
            imageResponse = fileManagementClient.saveImage(
                    new FileManagementClient.ImageRequest(
                            appName,
                            request.getBytes(),
                            request.getOriginalFilename(),
                            request.getSize(),
                            request.getContentType()
                    ));

        } catch (final IOException e) {
            throw new RuntimeException(e);
        }

        return new FileResponse(imageResponse.imageUrl(), imageResponse.id(), imageResponse.originalName(), imageResponse.fileType());
    }

}

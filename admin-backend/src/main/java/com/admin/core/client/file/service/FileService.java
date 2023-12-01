package com.admin.core.client.file.service;

import com.admin.core.supported.AddSupported;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface FileService extends AddSupported<MultipartFile, FileService.FileResponse> {

    record FileResponse(String url, UUID id, String originalName, String fileType) {
    }

}

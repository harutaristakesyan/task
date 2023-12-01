package com.web.core.client.file.service;

import com.web.core.supported.AddSupported;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.UUID;

public interface FileService extends AddSupported<MultipartFile, FileService.FileResponse> {

    record FileResponse(String url, UUID id) implements Serializable {
    }

}

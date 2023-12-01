package com.file.managemnet.app.service;

import org.springframework.core.io.Resource;

public interface IoService {

    String store(byte[] image, String fileName, String appName, String filePath);

    Resource load(String fileName);
}

package com.file.managemnet.app.service;

import com.file.managemnet.app.service.IoService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Service
@RequiredArgsConstructor
public class IoServiceImpl implements IoService {

    private final String rootPath = System.getProperty("user.home");

    @Override
    public String store(final byte[] file, final String fileName, final String appName, final String filePath) {
        if (file == null) {
            return null;
        }

        final var appPath = appName.concat("/");

        final var savedLocation = rootPath.concat(filePath).concat(appPath);
        final var path = Path.of(savedLocation);
        if (!Files.exists(path)) {
            try {
                Files.createDirectory(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return appPath.concat(saveFile(file, fileName, path));
    }

    @Override
    public Resource load(final String filePath) {
        try {
            Path file = Path.of(rootPath.concat(filePath));
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    private String saveFile(final byte[] file, String fileName, final Path savedLocation) {
        fileName = String.valueOf(System.currentTimeMillis()).concat(fileName).substring(fileName.length() - 5).replaceAll("\\s", "");
        try {
            Files.copy(new ByteArrayInputStream(file), savedLocation.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileName;
    }
}

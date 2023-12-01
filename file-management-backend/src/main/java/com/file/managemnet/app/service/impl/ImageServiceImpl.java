package com.file.managemnet.app.service.impl;

import com.file.managemnet.app.service.ImageService;
import com.file.managemnet.app.persistence.domain.ImageEntity;
import com.file.managemnet.app.mapper.ImageMapper;
import com.file.managemnet.app.data.ImageRequest;
import com.file.managemnet.app.data.ImageResponse;
import com.file.managemnet.app.persistence.repository.ImageRepository;
import com.file.managemnet.app.service.IoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    @Value("${file.path.images}")
    private String imagesPath;

    private final IoService ioService;

    private final ImageMapper imageMapper;

    private final ImageRepository imageRepository;

    @Override
    public ImageResponse add(final ImageRequest request) {
        var fileName = ioService.store(request.image(), request.imageName(), request.appName(), imagesPath);
        var entity = buildEntity(request);
        entity.setImageUrl(fileName);
        return imageMapper.toResponse(imageRepository.save(entity));
    }

    private ImageEntity buildEntity(final ImageRequest request) {
        var imageEntity = new ImageEntity();
        imageEntity.setApplicationName(request.appName());
        imageEntity.setOriginalName(request.imageName());
        imageEntity.setFileType(request.type());
        imageEntity.setSize(request.size());
        imageEntity.setUsed(false);
        return imageEntity;
    }

    @Override
    @Transactional(readOnly = true)
    public Resource get(final UUID uuid) {
        return imageRepository.findById(uuid)
                .map(entity -> ioService.load(imagesPath.concat("/").concat(entity.getImageUrl())))
                .orElseThrow(entityNotFoundException(ImageEntity.class, uuid));
    }

}

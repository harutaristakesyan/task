package com.file.managemnet.app.service;

import com.file.managemnet.base.services.AddSupported;
import com.file.managemnet.base.services.GetSupported;
import com.file.managemnet.app.data.ImageRequest;
import com.file.managemnet.app.data.ImageResponse;
import org.springframework.core.io.Resource;

import java.util.UUID;

public interface ImageService extends AddSupported<ImageRequest, ImageResponse>,
        GetSupported<UUID, Resource> {

}

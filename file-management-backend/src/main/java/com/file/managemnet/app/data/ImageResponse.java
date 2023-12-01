package com.file.managemnet.app.data;

import java.util.UUID;

public record ImageResponse(String imageUrl, UUID id, String originalName, String fileType) {
}

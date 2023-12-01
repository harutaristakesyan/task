package com.web.core.client.file.data;

public record ImageRequest(String appName, byte[] image, String imageName, long size, String type) {
}


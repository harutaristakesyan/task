package com.file.managemnet.app.data;

public record ImageRequest(String appName, byte[] image, String imageName, long size, String type) {
}

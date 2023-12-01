package com.configuration.core.data;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseMessages {

    AMENITY("Amenity", 100);

    private final String message;

    private final int code;

}

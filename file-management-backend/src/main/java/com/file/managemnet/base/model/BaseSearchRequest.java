package com.file.managemnet.base.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseSearchRequest {


    private int page;

    private int size;

    public PageRequest toPage(){
        return PageRequest.of(page, size);
    }
}


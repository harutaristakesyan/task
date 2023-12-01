package com.configuration.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseSearchCriteria {

    private int page = 0;

    private int size = 10;

    public PageRequest toPage(){
        return PageRequest.of(page, size);
    }
}


package com.web.app.persistence.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
public class FileDomain {

    private UUID id;

    private String name;

    private String type;

}

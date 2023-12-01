package com.file.managemnet.base.response;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public record AbstractListResponse<O>(Integer total, List<O> items) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}

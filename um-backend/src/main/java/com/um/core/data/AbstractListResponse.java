package com.um.core.data;

import java.util.List;

public record AbstractListResponse<O>(long total, List<O> items) {
}

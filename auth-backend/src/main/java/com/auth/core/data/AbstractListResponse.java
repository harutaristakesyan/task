package com.auth.core.data;

import java.util.List;

public record AbstractListResponse<O>(Integer total, List<O> items) {
}

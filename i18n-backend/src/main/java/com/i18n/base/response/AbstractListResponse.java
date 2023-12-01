package com.i18n.base.response;

import java.util.List;

public record AbstractListResponse<O>(Integer total, List<O> items) {
}

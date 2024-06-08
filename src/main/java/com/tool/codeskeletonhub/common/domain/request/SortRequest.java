package com.tool.codeskeletonhub.common.domain.request;

import com.tool.codeskeletonhub.common.domain.search.SortDirection;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SortRequest {

    private String key;
    private SortDirection direction;
}

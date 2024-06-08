package com.tool.codeskeletonhub.common.domain.request;

import com.tool.codeskeletonhub.common.domain.search.FieldType;
import com.tool.codeskeletonhub.common.domain.search.Operator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilterRequest {

    private String key;
    private FieldType fieldType;
    private Operator operator;
    private Object value;
}

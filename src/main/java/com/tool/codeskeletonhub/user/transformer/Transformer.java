package com.tool.codeskeletonhub.user.transformer;

public interface Transformer<E, D> {

    D toResource(E entity);

    E toEntity(D dto);
}

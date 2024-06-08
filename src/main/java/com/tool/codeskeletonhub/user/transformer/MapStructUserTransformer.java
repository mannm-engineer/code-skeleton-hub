package com.tool.codeskeletonhub.user.transformer;

import com.tool.codeskeletonhub.user.entity.User;
import com.tool.codeskeletonhub.user.resource.UserResource;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapStructUserTransformer extends UserTransformer {

    MapStructUserTransformer INSTANCE = Mappers.getMapper(MapStructUserTransformer.class);

    @Override
    UserResource toResource(User user);

    @Override
    User toEntity(UserResource userResource);
}

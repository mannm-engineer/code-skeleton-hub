package com.tool.codeskeletonhub.user.service;

import com.tool.codeskeletonhub.common.domain.request.SearchRequest;
import com.tool.codeskeletonhub.user.resource.UserResource;
import org.springframework.data.domain.Page;

public interface UserService {

    Page<UserResource> findAllUsers(SearchRequest searchRequest);

    UserResource findUserById(Long id);

    UserResource createUser(UserResource userResource);

    void replaceUser(UserResource userResource);

    void patchUser(Long id, UserResource userResource);

    void deleteUser(Long id);
}

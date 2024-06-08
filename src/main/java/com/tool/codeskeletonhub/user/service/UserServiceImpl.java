package com.tool.codeskeletonhub.user.service;

import com.tool.codeskeletonhub.common.domain.request.SearchRequest;
import com.tool.codeskeletonhub.common.domain.search.SearchSpecification;
import com.tool.codeskeletonhub.user.entity.User;
import com.tool.codeskeletonhub.user.repository.UserRepository;
import com.tool.codeskeletonhub.user.resource.UserResource;
import com.tool.codeskeletonhub.user.transformer.UserTransformer;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserTransformer userTransformer;

    public UserServiceImpl(UserRepository userRepository, UserTransformer userTransformer) {
        this.userRepository = userRepository;
        this.userTransformer = userTransformer;
    }

    @Override
    public Page<UserResource> findAllUsers(final SearchRequest searchRequest) {
        SearchSpecification<User> specification = new SearchSpecification<>(searchRequest);
        Pageable pageable = SearchSpecification.getPageable(searchRequest.getPage(), searchRequest.getSize());
        return userRepository.findAll(specification, pageable).map(userTransformer::toResource);
    }

    @Override
    public UserResource findUserById(final Long id) {
        return userRepository.findById(id).map(userTransformer::toResource).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public UserResource createUser(final UserResource userResource) {
        User user = userTransformer.toEntity(userResource);
        userRepository.save(user);
        return userTransformer.toResource(user);
    }

    @Override
    public void replaceUser(final UserResource userResource) {
        User user = userTransformer.toEntity(userResource);

        if (!userRepository.existsById(user.getId()))
            throw new EntityNotFoundException();

        userRepository.save(user);
    }

    @Override
    public void patchUser(final Long id, final UserResource userResource) {
        User user = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(final Long id) {
        if (!userRepository.existsById(id))
            return;

        userRepository.deleteById(id);
    }
}

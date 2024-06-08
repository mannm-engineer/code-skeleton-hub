package com.tool.codeskeletonhub.user.controller;

import com.tool.codeskeletonhub.common.domain.request.SearchRequest;
import com.tool.codeskeletonhub.user.resource.UserResource;
import com.tool.codeskeletonhub.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Page<UserResource>> findUsers(final @Valid @RequestBody SearchRequest searchRequest) {
        return ResponseEntity.ok(userService.findAllUsers(searchRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResource> findUserById(final @PathVariable Long id) {
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserResource> createUser(final @Valid @RequestBody UserResource userResource) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userResource));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> replaceUser(final @PathVariable Long id, final @Valid @RequestBody UserResource userResource) {
        if (!id.equals(userResource.getId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        userService.replaceUser(userResource);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> patchUser(final @PathVariable Long id, final @RequestBody UserResource userResource) {
        userService.patchUser(id, userResource);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(final @PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}

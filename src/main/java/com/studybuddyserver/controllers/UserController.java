package com.studybuddyserver.controllers;

import com.studybuddyserver.dtos.PublicUserInfoRequest;
import com.studybuddyserver.dtos.RegisterUserRequest;
import com.studybuddyserver.dtos.UpdateUserRequest;
import com.studybuddyserver.dtos.UserDto;
import com.studybuddyserver.facades.DtoFacade;
import com.studybuddyserver.entities.User;
import com.studybuddyserver.mappers.UserMapper;
import com.studybuddyserver.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.stream.Collectors;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final DtoFacade dtoFacade;

    @GetMapping()
    public Iterable<PublicUserInfoRequest> getAllUsers() {
        return dtoFacade.getAllUsers();
    }

    @GetMapping("/{id}/myInfo")
    public ResponseEntity<PublicUserInfoRequest> getUserById(@PathVariable(name = "id") String id) {
        return dtoFacade.getUserById(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable(name = "id") String id) {
        return dtoFacade.getUser(id);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody RegisterUserRequest register, UriComponentsBuilder uriBuilder) {
        return dtoFacade.createUser(register, uriBuilder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable String id, @RequestBody UpdateUserRequest update) {
        return dtoFacade.updateUser(id, update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable String id) {
        return dtoFacade.deleteUser(id);
    }
}
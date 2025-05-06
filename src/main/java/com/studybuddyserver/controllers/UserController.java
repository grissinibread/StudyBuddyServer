package com.studybuddyserver.controllers;

import com.studybuddyserver.dtos.PublicUserInfoRequest;
import com.studybuddyserver.dtos.RegisterUserRequest;
import com.studybuddyserver.dtos.UpdateUserRequest;
import com.studybuddyserver.dtos.UserDto;
import com.studybuddyserver.entities.User;
import com.studybuddyserver.mappers.UserMapper;
import com.studybuddyserver.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @GetMapping()
    public List<PublicUserInfoRequest> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::info).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable(name = "id") String id) {
        var user = userRepository.findById(id).orElse(null);
        if (user == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(userMapper.toDto(user));
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody RegisterUserRequest register, UriComponentsBuilder uriBuilder) {
        var user = userMapper.toEntity(register);
        var savedUser = userRepository.save(user);

        System.out.println(savedUser);
        var userDto = userMapper.toDto(savedUser);
        var uri = uriBuilder.path("/users/{id}").buildAndExpand(userDto.getId()).toUri();

        return ResponseEntity.created(uri).body(userDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable String id, @RequestBody UpdateUserRequest update) {
        var user = userRepository.findById(String.valueOf(id)).orElse(null);
        if(user == null)
            return ResponseEntity.notFound().build();

        userMapper.updateUser(update, user);
        userRepository.save(user);

        return ResponseEntity.ok(userMapper.toDto(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable String id) {
        var user = userRepository.findById(String.valueOf(id)).orElse(null);
        if(user == null)
            return ResponseEntity.notFound().build();

        userRepository.delete(user);
        return ResponseEntity.ok(userMapper.toDto(user));
    }
}
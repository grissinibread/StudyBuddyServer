package com.studybuddyserver.facades;

import com.studybuddyserver.dtos.RegisterUserRequest;
import com.studybuddyserver.dtos.UpdateUserRequest;
import com.studybuddyserver.dtos.UserDto;
import com.studybuddyserver.mappers.UserMapper;
import com.studybuddyserver.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@AllArgsConstructor
public class DtoFacade {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Iterable<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    public ResponseEntity<UserDto> getUser(@PathVariable(name = "id") String id) {
        var user = userRepository.findById(id).orElse(null);
        if (user == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(userMapper.toDto(user));
    }

    public ResponseEntity<UserDto> createUser(@RequestBody RegisterUserRequest register, UriComponentsBuilder uriBuilder) {
        var user = userMapper.toEntity(register);
        var savedUser = userRepository.save(user);

        System.out.println(savedUser);
        var userDto = userMapper.toDto(savedUser);
        var uri = uriBuilder.path("/users/{id}").buildAndExpand(userDto.getId()).toUri();

        return ResponseEntity.created(uri).body(userDto);
    }

    public ResponseEntity<UserDto> updateUser(@PathVariable String id, @RequestBody UpdateUserRequest update) {
        var user = userRepository.findById(String.valueOf(id)).orElse(null);
        if(user == null)
            return ResponseEntity.notFound().build();

        userMapper.updateUser(update, user);
        userRepository.save(user);

        return ResponseEntity.ok(userMapper.toDto(user));
    }

    public ResponseEntity<UserDto> deleteUser(@PathVariable String id) {
        var user = userRepository.findById(String.valueOf(id)).orElse(null);
        if(user == null)
            return ResponseEntity.notFound().build();

        userRepository.delete(user);
        return ResponseEntity.ok(userMapper.toDto(user));
    }
}

package com.studybuddyserver.controllers;

import com.studybuddyserver.dtos.UserDto;
import com.studybuddyserver.entities.User;
import com.studybuddyserver.mappers.UserMapper;
import com.studybuddyserver.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @GetMapping()
    public Iterable<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable String id) {
        var user = userRepository.findById(id).orElse(null);
        if (user == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(userMapper.toDto(user));
    }

    @PostMapping("/addUser")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        var user = User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .build();

        var savedUser = userRepository.save(user);

        return ResponseEntity.ok(userMapper.toDto(savedUser));
    }

    private UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
    }
}

//
//    @DeleteMapping("/id")
//    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
//        if(!userRepository.existsById(id)) {
//            return ResponseEntity.notFound().build();
//        }
//        userRepository.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }



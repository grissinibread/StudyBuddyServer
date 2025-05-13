package com.studybuddyserver.facades;

import com.studybuddyserver.dtos.*;
import com.studybuddyserver.entities.User;
import com.studybuddyserver.mappers.UserMapper;
import com.studybuddyserver.matching.Match;
import com.studybuddyserver.matching.MatchingAlg;
import com.studybuddyserver.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Component
@AllArgsConstructor
public class DtoFacade {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final MatchingAlg matchingAlg;

    public List<PublicUserInfoRequest> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::info).toList();
    }

    public ResponseEntity<PublicUserInfoRequest> getUserById(@PathVariable(name = "id") String id) {
        var user = userRepository.findById(id).orElse(null);
        if(user == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(userMapper.info(user));
    }

    public ResponseEntity<UserDto> login(@RequestBody LoginRequest request) {
        System.out.println("Login endpoint hit");
        var user = userRepository.findByEmail(request.getEmail());
        if(user == null || !user.getPassword().equals(request.getPassword()))
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(userMapper.toDto(user)); // or handle login success/failure
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

    //for matching
    public List<Match> getMatches(@PathVariable String currentUserIdentifier){
        System.out.println("Getting matches for user: " + currentUserIdentifier);
        User loggedInUser = userRepository.findByEmail(currentUserIdentifier);
        if (loggedInUser == null) { System.out.println("returning null"); return null;}
        return matchingAlg.returnMatches(loggedInUser);
    }
}

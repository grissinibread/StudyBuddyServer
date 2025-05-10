package com.studybuddyserver.controllers;

import com.studybuddyserver.matching.Match;
import com.studybuddyserver.matching.MatchingAlg;
import com.studybuddyserver.repositories.UserRepository;
import com.studybuddyserver.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
@CrossOrigin(origins = "*")
public class MatchController {
    @Autowired
    private MatchingAlg matchingAlg;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{userId}")
    public List<Match> getMatches(@PathVariable String userId){
        System.out.println("Getting matches for user: " + userId);
        User loggedInUser = userRepository.findById(userId).orElse(null);
        if (loggedInUser == null) { System.out.println("returning null"); return null;}
        return matchingAlg.returnMatches(loggedInUser);
    }
}

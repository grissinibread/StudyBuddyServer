package com.studybuddyserver.controllers;

import com.studybuddyserver.matching.Match;
import com.studybuddyserver.matching.MatchingAlg;
import com.studybuddyserver.facades.DtoFacade;
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
    private DtoFacade dtoFacade;

    @GetMapping("/{currentUserIdentifier}")
    public List<Match> getMatches(@PathVariable String currentUserIdentifier){
        return dtoFacade.getMatches(currentUserIdentifier);
    }
}

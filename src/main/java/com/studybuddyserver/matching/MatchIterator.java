package com.studybuddyserver.matching;

import java.util.List;

public class MatchIterator implements MatchIteratorIF {
    private final List<Match> matches; //hold matches
    private int index = 0;

    //constructor with list to iterate through
    public MatchIterator(List<Match> matches) {
        this.matches = matches;
    }

    @Override
    public boolean hasNext() {
        return index < matches.size();
    }
    @Override
    public Match next() { //returns current moves to next
        return hasNext() ? matches.get(index++) : null;
    }
}

package com.studybuddyserver.matching;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class MatchCollection implements Iterable<Match> {
    private List<Match> matches = new ArrayList<>();
    public MatchCollection(List<Match> matches) {
        this.matches = matches;
    }
    @Override
    public Iterator<Match> iterator() {
        return new MatchIterator(matches);
    }
}

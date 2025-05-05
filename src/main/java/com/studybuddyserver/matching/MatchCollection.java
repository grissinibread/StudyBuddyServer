package com.studybuddyserver.matching;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class MatchCollection implements Iterable<Match> {
    private List<Match> matches = new ArrayList<>();

    @Override
    public Iterator<Match> iterator() {
        return new MatchIterator(matches);
    }
}

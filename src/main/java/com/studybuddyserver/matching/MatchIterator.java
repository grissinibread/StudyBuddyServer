package com.studybuddyserver.matching;

import java.util.List;
import java.util.Iterator;

public class MatchIterator implements Iterator<Match> {
    private final Iterator<Match> iterator;

    public MatchIterator(List<Match> matches) {
        this.iterator = matches.iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Match next() {
        return iterator.next();
    }
}

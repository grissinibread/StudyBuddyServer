package com.studybuddyserver.matching;

import java.util.Iterator;

public class MatchDisplay {
    static MatchCollection matchCollection;

    public MatchDisplay(MatchCollection matchCollection) {
        this.matchCollection = matchCollection;
    }
    //might need to return a list of information or something
    public void printMatches(){
        Iterator<Match> iterator = matchCollection.iterator();
        while(iterator.hasNext()){
            Match match = iterator.next();
            System.out.println(match.getName());
            //TODO: PASS INFO TO BE DISPLAYED MATCH IN DISCOVER GUI
        }
    }
}

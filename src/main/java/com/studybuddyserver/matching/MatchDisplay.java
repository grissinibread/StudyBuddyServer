package com.studybuddyserver.matching;

import java.util.Iterator;

public class MatchDisplay {
    static MatchCollection matchCollection = new MatchCollection();

    //might need to return a list of information or something
    public void printMatches(){
        Iterator<Match> iterator = matchCollection.iterator();
        while(iterator.hasNext()){
            Match match = iterator.next();
            System.out.println(match);
            //TODO: PASS INFO TO BE DISPLAYED MATCH IN DISCOVER GUI
        }
    }
}

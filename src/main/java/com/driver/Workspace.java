package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
        super(emailId, Integer.MAX_VALUE);
        this.calendar = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        this.calendar.add(meeting);
    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
        ArrayList<Pair<LocalTime, Integer>> endTime = new ArrayList<>();
        for(int i = 0; i < calendar.size(); i++) {
            endTime.add(Pair.of(calendar.get(i).getEndTime(), i));
        }
        Collections.sort(endTime);
        LocalTime presentMeetingEndTime = endTime.get(0).getLeft();
        int meetingsCanAttend = 0;

        if(!endTime.isEmpty()) {
            meetingsCanAttend++;
        }

        for(int i = 1; i < endTime.size(); i++) {
            if(calendar.get(endTime.get(i).getRight()).getStartTime().isAfter(presentMeetingEndTime)) {
                meetingsCanAttend++;
                presentMeetingEndTime = endTime.get(i).getLeft();
            }
        }
        return meetingsCanAttend;
    }
}
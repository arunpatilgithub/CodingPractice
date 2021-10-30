package com.ap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsPractice {

    public static void main(String[] args) {

        System.out.println(minMeetingRooms(new int[][] {{7,10},{2,4}}));
        System.out.println(minMeetingRooms(new int[][] {{0,30},{5,10},{15,20}}));
    }

    public static int minMeetingRooms(int[][] intervals) {

        //Sort meeting rooms by their start time.
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));

        PriorityQueue<Integer> meetingQueue = new PriorityQueue<>(Comparator.naturalOrder());
        meetingQueue.add(intervals[0][1]);

        for (int i=1; i< intervals.length; i++) {
            int earliestMeetingTime = meetingQueue.peek();

            if (intervals[i][0] < earliestMeetingTime) {
                meetingQueue.add(intervals[i][1]);
            } else {
                meetingQueue.poll();
                meetingQueue.add(intervals[i][1]);
            }
        }

        return meetingQueue.size();
    }

}

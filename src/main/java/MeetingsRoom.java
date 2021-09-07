import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

@Slf4j
public class MeetingsRoom {

    public static void main(String[] args) {

        System.out.println(minMeetingRooms(new int[][] {{7,10},{2,4}}));
    }

    private static int minMeetingRooms(int[][] intervals) {

        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> meetingAllocator = new PriorityQueue<>(intervals.length, Comparator.naturalOrder());

        meetingAllocator.add(intervals[0][1]);

        for (int i=1; i< intervals.length; i++) {

            int firstMeetingEndTime = meetingAllocator.peek();

            if (firstMeetingEndTime <= intervals[i][0]) {
                meetingAllocator.poll();
            }

            meetingAllocator.add(intervals[i][1]);

        }

        return meetingAllocator.size();

    }
}

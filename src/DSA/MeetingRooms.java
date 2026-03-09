package DSA;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms {

    private int minMeetingRooms(int[][] intervals){
        if (intervals == null || intervals.length == 0) return 0;

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int[] interval : intervals){
            int start = interval[0], end = interval[1];
            if (!minHeap.isEmpty() && minHeap.peek() <= start){
                minHeap.poll();
            }
            minHeap.offer(end);
        }
        return minHeap.size();
    }


    public static void main(String[] args){
        MeetingRooms solver = new MeetingRooms();
        int[][] a = {{0,30}, {5,10}, {15,20}};
        int [][] b = {{7, 10}, {2, 4}};
        System.out.println(solver.minMeetingRooms(a));
        System.out.println(solver.minMeetingRooms(b));
    }
}

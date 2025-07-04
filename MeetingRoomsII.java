import java.util.*;

/*
Time complexity -> O(nlogk) where n is the number of meetings and k is the endtimes of the meetings that require meeting rooms
Space complexity -> O(k) where k is the count of endtimes of the meetings that require meeting rooms
*/

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

        for (int[] m : intervals) {
            int currStart = m[0]; // 15
            if (!minHeap.isEmpty() && minHeap.peek() <= currStart) {
                minHeap.poll();
            }
            minHeap.add(m[1]); // [30, 20]
        }

        return minHeap.size();
    }
}

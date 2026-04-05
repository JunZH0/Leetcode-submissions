/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(a -> a.start));
        
        Queue<Integer> minHeap = new PriorityQueue<>();

        for (Interval interval : intervals) {
            int start = interval.start;
            int end = interval.end;

            if (!minHeap.isEmpty() && start >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.offer(end);
        }

        return minHeap.size();
    }
}

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
        Queue<Integer> minHeap = new PriorityQueue<>();
        intervals.sort(Comparator.comparingInt(a -> a.start));

        for (Interval interval : intervals) {
            if (!minHeap.isEmpty() && interval.start >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.offer(interval.end);
        }

        return minHeap.size();
    }
}

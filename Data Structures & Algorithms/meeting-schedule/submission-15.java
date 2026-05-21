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
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(a -> a.start));

        for (int i = 1; i < intervals.size(); i++) {
            int start = intervals.get(i).start;
            int prevEnd = intervals.get(i - 1).end;

            if (prevEnd > start) {
                return false;
            }
        }
        return true;
    }
}

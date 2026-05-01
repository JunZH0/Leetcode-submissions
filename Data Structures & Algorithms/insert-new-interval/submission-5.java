class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];

        int i = 0; 
        int len = intervals.length;

        while (i < len && intervals[i][1] < start) {
            res.add(intervals[i]);
            i++;
        }

        while (i < len && end >= intervals[i][0]) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }

        res.add(new int[]{start, end});

        while (i < len) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);

    }
}

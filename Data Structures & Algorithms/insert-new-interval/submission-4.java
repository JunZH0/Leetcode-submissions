class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int len = intervals.length;
        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        while (i < len && intervals[i][1] < newStart) {
            res.add(intervals[i]);
            i++;
        }

        while (i < len && newEnd >= intervals[i][0]) {
            newStart = Math.min(newStart, intervals[i][0]);
            newEnd = Math.max(newEnd, intervals[i][1]);
            i++;
        }
        
        res.add(new int[]{newStart, newEnd});

        while (i < len) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);
    }
}

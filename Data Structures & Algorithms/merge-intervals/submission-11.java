class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            int prevEnd = res.get(res.size() - 1)[1];

            if (start <= prevEnd) {
                res.get(res.size() - 1)[1] = Math.max(prevEnd, end);
            } else {
                res.add(intervals[i]);
            }
        }

        return res.toArray(new int[res.size()][]);

    }
}

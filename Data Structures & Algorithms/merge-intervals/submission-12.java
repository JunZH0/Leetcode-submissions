class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> res = new ArrayList<>();

        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            int prev = res.get(res.size() - 1)[1];

            if (start <= prev) {
                res.get(res.size() - 1)[1] = Math.max(prev, end);
            } else {
                res.add(new int[]{start, end});
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}

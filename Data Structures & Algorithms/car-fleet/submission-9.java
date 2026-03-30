class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] res = new int[position.length][2];

        for (int i = 0; i < position.length; i++) {
            res[i][0] = position[i];
            res[i][1] = speed[i];
        }

        Arrays.sort(res, (a, b) -> Integer.compare(b[0], a[0]));

        Stack<Double> stack = new Stack<>();

        for (int[] pair : res) {
            double time = (double) (target - pair[0]) / pair[1];

            if (!stack.isEmpty() && time <= stack.peek()) {
                continue;
            }
            stack.push(time);
        }
    return stack.size();
    }
}

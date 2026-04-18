class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] fleet = new int[position.length][2];

        for (int i = 0; i < position.length; i++) {
            fleet[i][0] = position[i];
            fleet[i][1] = speed[i];
        }

        Arrays.sort(fleet, (a,b) -> Double.compare(b[0], a[0]));

        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < fleet.length; i++) {
            double time = (double)(target - fleet[i][0]) / fleet[i][1];

            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
            
        }
        return stack.size();
    }
}

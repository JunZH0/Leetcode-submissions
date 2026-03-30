class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];

            while (!stack.isEmpty() && t > temperatures[stack.peek()]) {
                int prevDay = stack.pop();
                res[prevDay] = i - prevDay;
            }
            stack.push(i);
        }
        return res;
    }
}

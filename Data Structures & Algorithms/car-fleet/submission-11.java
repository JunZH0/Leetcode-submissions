class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] cars = new double[position.length][2];

        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < cars.length; i++) {
            double currTime = (double)(target - cars[i][0]) / cars[i][1];

            if (stack.isEmpty() || currTime > stack.peek()) {
                stack.push(currTime);
            }

        }
        return stack.size();
    }
}

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for (String c : tokens) {
            if ("+".equals(c)) {
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(c)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if ("*".equals(c)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(c)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.peek();
    }
}

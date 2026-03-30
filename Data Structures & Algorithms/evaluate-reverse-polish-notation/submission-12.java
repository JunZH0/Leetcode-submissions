class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String t : tokens) {
            if ("+".equals(t)) {
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(t)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if ("*".equals(t)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(t)) {
                int d = stack.pop();
                int e = stack.pop();
                stack.push(e / d);
            } else {
                stack.push(Integer.parseInt(t));
            }
        }
        return stack.peek();
    }
}

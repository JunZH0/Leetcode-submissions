class MinStack {
    
    private Stack<Integer> stack;
    private Stack<Integer> min;

    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);

        if (min.isEmpty() || val <= min.peek()) {
            min.push(val);
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) return;

        int temp = stack.pop();

        if (temp == min.peek()) {
            min.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

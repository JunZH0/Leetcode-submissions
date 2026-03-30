class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> closeToOpen = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        closeToOpen.put(')', '(');
        closeToOpen.put('}', '{');
        closeToOpen.put(']', '[');

        for (char c : s.toCharArray()) {
            if (closeToOpen.containsKey(c)) {
                if (!stack.isEmpty() && closeToOpen.get(c) == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
    return stack.isEmpty();
    }
}

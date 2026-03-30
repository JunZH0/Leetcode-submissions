class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> closedToOpen = new HashMap<>();
        closedToOpen.put(')', '(');
        closedToOpen.put(']', '[');
        closedToOpen.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (closedToOpen.containsKey(c)) {
                if (!stack.isEmpty() && closedToOpen.get(c) == stack.peek()) {
                    stack.pop();
                } else{
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
    return stack.isEmpty();
    }
}

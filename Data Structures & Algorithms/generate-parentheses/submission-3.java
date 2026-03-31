class Solution {

    private List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();

        backtrack(0, 0, new StringBuilder(), n);

        return res;    
    }

    private void backtrack(int openN, int closedN, StringBuilder cur, int n) {
        if (closedN == openN && openN == n) {
            res.add(cur.toString());
            return;
        }

        if (openN < n) {
            cur.append('(');
            backtrack(openN + 1, closedN, cur, n);
            cur.deleteCharAt(cur.length() - 1);
        }

        if (closedN < openN) {
            cur.append(')');
            backtrack(openN, closedN + 1, cur, n);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}

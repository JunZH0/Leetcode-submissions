class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        backtrack(0, 0, new StringBuilder(),res, n);

        return res;
    }

    private void backtrack(int openN, int closedN, StringBuilder sb, List<String> res, int n) {
        if (closedN == openN && openN == n) {
            res.add(sb.toString());
            return;
        }

        if (openN < n) {
            sb.append('(');
            backtrack(openN + 1, closedN, sb, res, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (closedN < openN) {
            sb.append(')');
            backtrack(openN, closedN + 1, sb, res, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

class Solution {        
    
    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();

        dfs(0, 0, new StringBuilder(), n);

        return res;
    }

    private void dfs(int openN, int closedN, StringBuilder cur, int n) {
        if (openN == closedN && openN == n) {
            res.add(cur.toString());
        }

        if (openN < n) {
            cur.append('(');
            dfs(openN + 1, closedN, cur, n);
            cur.deleteCharAt(cur.length() - 1);
        }

        if (closedN < openN) {
            cur.append(')');
            dfs(openN, closedN + 1, cur, n);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}

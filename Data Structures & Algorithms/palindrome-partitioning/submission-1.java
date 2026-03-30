class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();

        dfs(0, new ArrayList<>(), s);

        return res;
    }

    private void dfs(int i , List<String> cur, String s) {
        if (i == s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (isPali(i, j, s)) {
                cur.add(s.substring(i, j + 1));
                dfs(j + 1, cur, s);
                cur.remove(cur.size() - 1);
            }
        }
    } 

    private boolean isPali(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

class Solution {

    private List<List<String>> res;

    public List<List<String>> partition(String s) {
        res = new ArrayList<>();

        dfs(0, new ArrayList<>(), s);

        return res;
    }

    private void dfs(int i, List<String> word, String s) {
        if (i == s.length()) {
            res.add(new ArrayList<>(word));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (isPali(i, j, s)) {
                word.add(s.substring(i, j + 1));
                dfs(j + 1, word, s);
                word.remove(word.size() - 1);
            }
        }
    }

    private boolean isPali(int l, int r, String s) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}

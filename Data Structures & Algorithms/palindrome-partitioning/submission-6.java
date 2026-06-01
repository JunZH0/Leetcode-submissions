class Solution {

    private List<List<String>> res;

    public List<List<String>> partition(String s) {
        res = new ArrayList<>();

        backtrack(0, new ArrayList<>(), s);

        return res;
    }

    private void backtrack(int i, List<String> curr, String s) {
        if (i >= s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (isPali(i, j, s)) {
                curr.add(s.substring(i, j + 1));
                backtrack(j + 1, curr, s);
                curr.remove(curr.size() - 1);
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

class Solution {

    private String[] mappings = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

    private List<String> res;    

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();

        if (digits.length() == 0) {
            return res;
        }

        backtrack(0, "", digits);

        return res;
    }

    private void backtrack(int i, String cur, String digits) {
        if (cur.length() == digits.length()) {
            res.add(cur);
            return;
        }

        String chars = mappings[digits.charAt(i) - '0'];

        for (char c : chars.toCharArray()) {
            backtrack(i + 1, cur + c, digits);
        }
    }
}

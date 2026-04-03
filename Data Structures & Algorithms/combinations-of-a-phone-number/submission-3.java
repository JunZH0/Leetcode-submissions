class Solution {

    private String[] mappings = new String[]{
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits.isEmpty()) {
            return res;
        }

        backtrack(0, "", res, digits);

        return res;
    }

    private void backtrack(int i, String st, List<String> res, String digits) {
        if (st.length() == digits.length()) {
            res.add(st);
            return;
        }

        String chars = mappings[digits.charAt(i) - '0'];
        for (char c : chars.toCharArray()) {
            backtrack(i + 1, st + c, res, digits);
        }
    }
}

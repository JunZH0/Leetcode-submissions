class Solution {

    private String[] mappings = new String[]{
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return res;
        }
        backtrack(0, "", digits);
        return res;
    }

    private void backtrack(int i , String st, String digits) {
        if (st.length() == digits.length()) {
            res.add(st);
            return;
        }

        String chars = mappings[digits.charAt(i) - '0'];
        for (char c : chars.toCharArray()) {
            backtrack(i + 1, st + c, digits);
        }
    }
}

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> rowSet = new HashMap<>();
        Map<Integer, Set<Integer>> colSet = new HashMap<>();
        Map<String, Set<Integer>> squareSet = new HashMap<>();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                int val = board[r][c];

                if (val == '.') continue;

                String squareKey = r / 3 + "," + c / 3;
                if (!rowSet.computeIfAbsent(r, v -> new HashSet<>()).add(val) ||
                    !colSet.computeIfAbsent(c, v -> new HashSet<>()).add(val) ||
                    !squareSet.computeIfAbsent(squareKey, v -> new HashSet<>()).add(val)) {
                        return false;
                }
            }
        }

        return true;

    }
}

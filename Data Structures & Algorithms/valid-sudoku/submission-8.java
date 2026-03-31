class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rSet = new HashMap<>();
        Map<Integer, Set<Character>> cSet = new HashMap<>();
        Map<String, Set<Character>> sqSet = new HashMap<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;

                String sqKey = (r / 3) + "," + (c / 3);

                if (rSet.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c]) ||
                    cSet.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c]) ||
                    sqSet.computeIfAbsent(sqKey, k -> new HashSet<>()).contains(board[r][c])) {
                        
                    return false;
                }

                rSet.get(r).add(board[r][c]);
                cSet.get(c).add(board[r][c]);
                sqSet.get(sqKey).add(board[r][c]);
            }
        }
        return true;
    }
}

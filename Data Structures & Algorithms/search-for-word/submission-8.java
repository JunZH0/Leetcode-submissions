class Solution {
    
    private int ROWS, COLS;

    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (dfs(r, c, 0, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int r, int c, int i, char[][] board, String word) {
        if (i == word.length()) return true;
        
        if (r < 0 || c < 0 || r >= ROWS ||
            c >= COLS || board[r][c] != word.charAt(i) ||
            board[r][c] == '#') {
                return false;
        }

        board[r][c] = '#';

        boolean res = dfs(r + 1, c, i + 1, board, word) ||
                      dfs(r - 1, c, i + 1, board, word) ||
                      dfs(r, c + 1, i + 1, board, word) ||
                      dfs(r, c - 1, i + 1, board, word);

        board[r][c] = word.charAt(i);

        return res;
    }
}

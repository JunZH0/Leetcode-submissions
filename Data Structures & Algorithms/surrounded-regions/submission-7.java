class Solution {
    
    private int ROWS, COLS;

    private int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;

        for (int r = 0; r < ROWS; r++) {
            if (board[r][0] == 'O') {
                dfs(r, 0, board);
            }

            if (board[r][COLS - 1] == 'O') {
                dfs(r, COLS - 1, board);
            }
        }

        for (int c = 0; c < COLS; c++) {
            if (board[0][c] == 'O') {
                dfs(0, c, board);
            }

            if (board[ROWS - 1][c] == 'O') {
                dfs(ROWS - 1, c, board);
            }
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void dfs(int r, int c, char[][] board) {
        if (r < 0 || c < 0 || r >= ROWS ||
            c >= COLS || board[r][c] != 'O') {
                return;
        }

        board[r][c] = 'T';

        for (int[] dir : directions) {
            dfs(r + dir[0], c + dir[1], board);
        }
    }
}

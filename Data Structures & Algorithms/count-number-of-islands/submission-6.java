class Solution {

    private int ROWS, COLS;

    private int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};

    public int numIslands(char[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        int islands = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == '1') {
                    if (dfs(r, c, grid)) {
                        islands++;
                    } 
                }
            }
        }
        return islands;
    }

    private boolean dfs(int r, int c, char[][] grid) {
        if (r < 0 || c < 0 || r >= ROWS ||
            c >= COLS || grid[r][c] == '0') {
                return false;
        }

        grid[r][c] = '0';

        for (int[] dir : directions) {
            dfs(r + dir[0], c + dir[1], grid);
        }
        return true;
    }
}

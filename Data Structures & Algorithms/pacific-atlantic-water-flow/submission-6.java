class Solution {

    private int ROWS, COLS;

    private int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();

        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        for (int r = 0; r < ROWS; r++) {
            dfs(r, 0, pac, heights, heights[r][0]);

            dfs(r, COLS - 1, atl, heights, heights[r][COLS - 1]);
        } 

        for (int c = 0; c < COLS; c++) {
            dfs(0, c, pac, heights, heights[0][c]);

            dfs(ROWS - 1, c, atl, heights, heights[ROWS - 1][c]);
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pac[r][c] && atl[r][c]) {
                    res.add(List.of(r, c));
                }
            }
        }
        return res;
    }

    private void dfs(int r, int c, boolean[][] current, int[][] heights, int prevHeight) {
        if (r < 0 || c < 0 || r >= ROWS ||
            c >= COLS || current[r][c] || heights[r][c] < prevHeight) {
                return;
        }

        current[r][c] = true;

        for (int[] dir : directions) {
            dfs(r + dir[0], c + dir[1], current, heights, heights[r][c]);
        }
    }
}

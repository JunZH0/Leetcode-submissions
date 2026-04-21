class Solution {

    private int ROWS, COLS;

    private int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();

        ROWS = heights.length;
        COLS = heights[0].length;

        boolean[][] atl = new boolean[ROWS][COLS];
        boolean[][] pac = new boolean[ROWS][COLS];

        // Left and Right
        for (int r = 0; r < ROWS; r++) {
            dfs(heights, pac, r, 0, heights[r][0]);

            dfs(heights, atl, r, COLS - 1, heights[r][COLS - 1]);
        }

        // Top and Bottom
        for (int c = 0; c < COLS; c++) {
            dfs(heights, pac, 0, c, heights[0][c]);

            dfs(heights, atl, ROWS - 1, c, heights[ROWS - 1][c]);
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

    private void dfs(int[][] heights, boolean[][] reachable, int r, int c, int prevHeight) {
        if (r < 0 || c < 0 || r >= ROWS ||
            c >= COLS || reachable[r][c] || heights[r][c] < prevHeight) {
                return;
        }

        reachable[r][c] = true;

        for (int[] dir : directions) {
            dfs(heights, reachable, r + dir[0], c + dir[1], heights[r][c]);
        }

    }
}

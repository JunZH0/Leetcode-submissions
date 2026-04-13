class Solution {

    private int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    private int ROWS, COLS;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if (heights == null || heights.length == 0) {
            return res;
        }

        ROWS = heights.length;
        COLS = heights[0].length;

        boolean[][] pac = new boolean[ROWS][COLS];;
        boolean[][] atl = new boolean[ROWS][COLS];

        // Start DFS from the top and bottom borders
        for (int c = 0; c < COLS; c++) {
            // Pacific border is the top row (0)
            dfs(heights, 0, c, pac, heights[0][c]);
            
            // Atlantic border is the bottom row (ROWS - 1);
            dfs(heights, ROWS - 1, c, atl, heights[ROWS - 1][c]);
        }

        for (int r = 0; r < ROWS; r++) {
            // Pacific left
            dfs(heights, r, 0, pac, heights[r][0]);

            // Atlantic right
            dfs(heights, r, COLS - 1, atl, heights[r][COLS - 1]);
        }

        // Find the intersection
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pac[r][c] && atl[r][c]) {
                    res.add(List.of(r, c));
                }
            }
        }
        
        return res;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] reachable, int prevHeight) {
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS ||
            reachable[r][c] || heights[r][c] < prevHeight) {
                return;
        }

        reachable[r][c] = true;

        for (int[] dir : directions) {
            dfs(heights, r + dir[0], c + dir[1], reachable, heights[r][c]);
        }
    }
}

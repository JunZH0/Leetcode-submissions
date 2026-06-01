class Solution {

    private int ROWS, COLS;

    private int[][] directions = {{1,0}, {-1,0}, {0,1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;

        List<List<Integer>> res = new ArrayList<>();
        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        for (int r = 0; r < ROWS; r++) {
            dfs(r, 0, pac, 0, heights);

            dfs(r, COLS - 1, atl, 0, heights);
        }

        for (int c = 0; c < COLS; c++) {
            dfs(0, c, pac, 0, heights);

            dfs(ROWS - 1, c, atl, 0, heights);
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pac[r][c] && atl[r][c]) {
                    res.add(new ArrayList<>(List.of(r, c)));
                }
            }
        }
        return res;
    }

    private void dfs(int r, int c, boolean[][] checked, int prevHeight, int[][] heights) {
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS ||
         heights[r][c] < prevHeight ||  checked[r][c]) {
                return;
        }

        checked[r][c] = true;

        for (int[] dir : directions) {
            dfs(r + dir[0], c + dir[1], checked, heights[r][c], heights);
        }
    }
}

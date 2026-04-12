class Solution {

    private int ROWS, COLS;

    private int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public void islandsAndTreasure(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 0) {
                    q.offer(new int[]{r, c});
                }
            }
        }

        if (q.size() == 0) return;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];

            for (int[] dir : directions) {
                int nr = row + dir[0];
                int nc = col + dir[1];

                if (nr >= ROWS || nc >= COLS || nr < 0 || nc < 0 ||
                    grid[nr][nc] != Integer.MAX_VALUE) {
                        continue;
                }

                q.offer(new int[]{nr, nc});

                grid[nr][nc] = grid[row][col] + 1;
            }
        }
    }
}

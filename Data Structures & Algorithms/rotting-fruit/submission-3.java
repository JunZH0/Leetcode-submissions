class Solution {

    private int ROWS, COLS;

    private int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public int orangesRotting(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>();
        int freshCount = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 2) {
                    q.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) return 0;
        int time = 0;
        while (!q.isEmpty() && freshCount > 0) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int row = cur[0];
                int col = cur[1];

                for (int[] dir : directions) {
                    int nr = row + dir[0];
                    int nc = col + dir[1];

                    if (nr >= 0 && nc >= 0 && nr < ROWS &&
                        nc < COLS && grid[nr][nc] == 1) {
                            grid[nr][nc] = 2;
                            q.offer(new int[]{nr, nc});
                            freshCount--;
                    }
                }
            }
            time++;
        }
        return freshCount == 0 ? time : -1;
    }
}

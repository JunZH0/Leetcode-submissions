class Solution {

    private int ROWS, COLS;

    private int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public int orangesRotting(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>();
        int fresh = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 2) {
                    q.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    fresh++; 
                }
            }
        }

        if (fresh == 0) return 0;
        int time = 0;

        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
        
            for (int i = 0; i < size; i++) {
                int[] node = q.poll();
                int row = node[0];
                int col = node[1];

                for (int[] dir : directions) {
                    int nr = row + dir[0];
                    int nc = col + dir[1];

                    if (nr >= 0 && nc >= 0 && nr < ROWS &&
                        nc < COLS && grid[nr][nc] == 1) {

                        grid[nr][nc] = 2;
                        q.offer(new int[]{nr, nc});
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}

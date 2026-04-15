class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rMap = new HashMap<>();
        Map<Integer, Set<Character>> cMap = new HashMap<>();
        Map<String, Set<Character>> sqMap = new HashMap<>();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == '.') continue;

                String sqKey = (r / 3) + "," + (c / 3);
                char val = board[r][c];
                if (rMap.computeIfAbsent(r, k -> new HashSet<>()).contains(val) ||
                    cMap.computeIfAbsent(c, k -> new HashSet<>()).contains(val) ||
                    sqMap.computeIfAbsent(sqKey, k -> new HashSet<>()).contains(val)) {
                        return false;
                } 

                rMap.get(r).add(val);
                cMap.get(c).add(val);
                sqMap.get(sqKey).add(val);
            }
        }
    return true;
    }
}

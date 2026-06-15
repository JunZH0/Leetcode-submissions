class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rMap = new HashMap<>();
        Map<Integer, Set<Character>> cMap = new HashMap<>();
        Map<String, Set<Character>> sqMap = new HashMap<>();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                
                if ('.' == board[r][c]) continue;

                String squareKey = r / 3 + "," + c / 3; 

                if (!rMap.computeIfAbsent(r, k -> new HashSet<>()).add(board[r][c]) ||
                    !cMap.computeIfAbsent(c, k -> new HashSet<>()).add(board[r][c]) ||
                    !sqMap.computeIfAbsent(squareKey, k -> new HashSet<>()).add(board[r][c])) {
                        return false;
                }
            }
        }
        return true;
    }
}

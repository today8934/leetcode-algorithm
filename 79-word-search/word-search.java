class Solution {

    private static int row;
    private static int col;
    private static char[][] board;
    private static String word;
    private static boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        this.row = board.length;
        this.col = board[0].length;
        this.board = board;
        this.word = word;
        this.visited = new boolean[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, 0)) return true;
            }
        }

        return false;
    }

    private boolean dfs(int r, int c, int index) {
        if (index == word.length()) return true;

        if (r > board.length - 1 || r < 0 || c > board[0].length - 1 || c < 0) return false;
        if (visited[r][c]) return false;
        if (board[r][c] != word.charAt(index)) return false;

        visited[r][c] = true;
        boolean isFounded = dfs(r + 1, c, index + 1) || dfs(r - 1, c, index + 1) || dfs(r, c + 1, index + 1) || dfs(r, c - 1, index + 1);
        visited[r][c] = false;

        return isFounded;
    }

    
}
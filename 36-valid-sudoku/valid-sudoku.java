class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowVisited = new boolean[9][9];
        boolean[][] colVisited = new boolean[9][9];
        boolean[][] boxVisited = new boolean[9][9];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                char c = board[row][col];

                if (c == '.') {
                    continue;
                }

                int index = Integer.parseInt(String.valueOf(c)) - 1;

                if (rowVisited[row][index]) {
                    return false;
                }

                if (colVisited[col][index]) {
                    return false;
                }

                int boxIndex = (row/3)*3 + (col/3);

                if (boxVisited[boxIndex][index]) {
                    return false;
                }

                rowVisited[row][index] = true;
                colVisited[col][index] = true;
                boxVisited[boxIndex][index] = true;
            }
        }

        return true;
    }
}
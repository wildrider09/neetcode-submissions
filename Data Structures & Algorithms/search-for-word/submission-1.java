class Solution {
    public boolean exist(char[][] board, String word) {

        int ROWS = board.length;
        int COLS = board[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (dfs(board, ROWS, COLS, r, c, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char board[][], int row, int col, int i, int j, int index, String word){
        
        if(index == word.length())
            return true;

        if(i<0 || j<0 || i>=row || j>=col)
            return false;

        if(board[i][j] != word.charAt(index) || board[i][j]=='#')
            return false;
        
        board[i][j] = '#';

        boolean flag = dfs(board, row, col, i-1, j, index+1, word) ||
                       dfs(board, row, col, i, j-1, index+1, word) ||
                       dfs(board, row, col, i+1, j, index+1, word) ||
                       dfs(board, row, col, i, j+1, index+1, word);

        board[i][j] = word.charAt(index);

        return flag;
    }
}

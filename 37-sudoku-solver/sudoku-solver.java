class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

       public boolean solve(char[][] board) {
        int n = board.length;
       for(int i=0; i<n; i++){
          for(int j=0; j<n; j++){
            if(board[i][j] == '.'){
                for(char ch = '1'; ch<='9' ; ch++){
                    if(isValid(board,i, j,ch)){
                        board[i][j] = ch;
                        if (solve(board)){
                             return true;
                        }
                         // Backtrack
                         board[i][j] = '.';
                    }
                }
                    return false;
            }
          }
       }
       return true;

       }

    public static boolean isValid(char[][] board, int row, int col, char ch){
      
      for(int i=0; i<9; i++){
          if(board[row][i] == ch){
            return false; 
          }
           if(board[i][col] == ch){
            return false; 
          }
          if(board[3*(row/3)+(i/3)][3*(col/3)+ i%3] == ch){
            return false;
          }

      }
      return true;
    }
}
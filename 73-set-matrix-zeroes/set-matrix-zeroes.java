class Solution {
    public void setZeroes(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] == 0){

                    markRow(matrix , i);
                    markCol(matrix , j);

                }
            }
        }

        
        for(int i = 0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] ==  -100000000){

                    matrix[i][j] = 0;

                }
            }
        }
        

    
    }
    public void markRow(int matrix[][] , int row){
         for(int j=0; j<matrix[0].length; j++){
            if(matrix[row][j] != 0)  matrix[row][j] = -100000000;
         }
    }
    public void markCol(int matrix[][] , int row){

        for(int i=0; i<matrix.length; i++){
            if(matrix[i][row] != 0)  matrix[i][row] = -100000000;
        }
    }
    
}
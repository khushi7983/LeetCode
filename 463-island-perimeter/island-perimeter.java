class Solution {
        int Perimeter = 0;
    public int islandPerimeter(int[][] grid) {
         for(int i = 0; i< grid.length; i++){
            for(int j=0 ; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                   dfs(i,j,grid);
                   return Perimeter;
                }
            } 
         } 
            return 0;          
    }
    public void dfs(int r ,int c , int grid[][]){
        int row = grid.length;
        int col = grid[0].length;
        if( r<0 || r>=row || c<0 || c>=col || grid[r][c] == 0){
            Perimeter++;
           return;
        }
        if( grid[r][c] == -1){
          return ;
        }
        grid[r][c] = -1;

        dfs(r-1,c,grid);
        dfs(r+1,c,grid);
        dfs(r,c-1,grid);
        dfs(r,c+1,grid);
         
    }
}
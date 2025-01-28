class Solution {
    public int numIslands(char[][] grid) {
        int Island = 0 ;
        for(int i =0 ; i<grid.length; i++){
            for( int j=0 ; j<grid[0].length ; j++){
                if(grid[i][j] == '1'){
                    dfs(i,j,grid);
                    Island++;

                }
            }
        }
            return Island;
    }
    public void dfs(int r, int c , char grid[][]){
        int row = grid.length;
        int cols = grid[0].length;

        if(r<0 || r>=row || c<0 || c>= cols || grid[r][c]=='0' || grid[r][c] == '$'){
            return ;
        }
        grid[r][c] ='$' ;

        dfs(r-1,c,grid);
        dfs(r,c+1,grid);
        dfs(r+1,c,grid);
        dfs(r,c-1,grid);

    }
}
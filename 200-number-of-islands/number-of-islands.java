// class Solution {
//     public int numIslands(char[][] grid) {
//         int rows=grid.length;
//         int cols=grid[0].length;
//         int island=0;
//         for(int r=0; r<rows; r++){
//             for(int c=0; c<cols; c++){
//                 if(grid[r][c]=='1'){
//                     island++;
//                     dfs(r, c, grid, rows, cols);
//                 }
//             }
//         }
//         return island;
//     }
//     private void dfs(int row, int col, char[][] grid, int rows, int cols){
//         int[][] directions=new int[][]{{0,1}, {1, 0}, {0, -1}, {-1, 0}};
//         if(row<0 || col <0 || row>=rows || col>=cols || grid[row][col]=='0'){
//             return;
//         }
//         grid[row][col]='0';
//         for(int[] dir : directions){
//             dfs(row+dir[0], col+dir[1], grid, rows, cols);
//         }
//     }
// }

class Solution{
    int m, n;
    public int numIslands(char[][] grid){
        m=grid.length;
        n=grid[0].length;
        int islands=0;
        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                if(grid[r][c]=='1'){
                    islands++;
                    dfs(grid, r, c);
                }
            }
        }
        return islands;
    }
    private void dfs(char[][] grid, int row, int col){
        if(row<0 || row>=m || col<0 || col>=n || grid[row][col]=='0') return;
        grid[row][col]='0';
        dfs(grid, row+1, col);
        dfs(grid, row, col+1);
        dfs(grid, row-1, col);
        dfs(grid, row, col-1);
    }
}
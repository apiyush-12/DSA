class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int maxArea=0;
        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                if(grid[r][c]==1){
                    int area=dfs(grid, r, c, n, m);
                    maxArea=Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }
    private int dfs(int[][] grid, int i, int j, int n, int m){
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j]==0){
            return 0;
        }
        grid[i][j]=0;
        int area=1;
        area+=dfs(grid, i+1, j, n, m);
        area+=dfs(grid, i, j+1, n, m);
        area+=dfs(grid, i-1, j, n, m);
        area+=dfs(grid, i, j-1, n, m);
        return area;
    }
}
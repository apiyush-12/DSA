class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> queue=new LinkedList<>();
        boolean[][] visited=new boolean[m][n];
        int freshCount=0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i, j});
                    visited[i][j]=true;
                }
                if(grid[i][j]==1){
                    freshCount++;
                }
            }
        }

        if(freshCount==0){
            return 0;
        }
        int minutes=0;
        int[][] directions={
            {0,1}, {0,-1}, {1,0}, {-1,0}
        };
        // BFS
        while(!queue.isEmpty()){
            int size=queue.size();
            boolean rootenThisMinute=false;
            for(int i=0; i<size; i++){
                int[] current=queue.poll();
                int row=current[0];
                int col=current[1];
                for(int[] dir: directions){
                    int newR=row+dir[0];
                    int newC=col+dir[1];

                    if(newR>=0 && newR<m && newC>=0 && newC<n && !visited[newR][newC] && grid[newR][newC]==1){
                        visited[newR][newC]=true;
                        queue.offer(new int[]{newR, newC});
                        freshCount--;
                        rootenThisMinute=true;
                    }
                }
            }
            if(rootenThisMinute){
                minutes++;
            }
        }
        return freshCount==0 ? minutes : -1;

    }
}
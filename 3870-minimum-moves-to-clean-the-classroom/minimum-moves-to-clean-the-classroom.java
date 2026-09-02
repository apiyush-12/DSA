// class Solution {
//     public int minMoves(String[] classroom, int energy) {
//         int m = classroom.length;
//         int n = classroom[0].length();
//         int[][] litterId = new int[m][n];
//         for(int i=0; i<m; i++) Arrays.fill(litterId[i], -1);
//         int startR = 0, startC = 0;
//         int litterCount = 0;
//         for(int i=0; i<m; i++){
//             for(int j=0; j<n; j++){
//                 char ch = classroom[i].charAt(j);
//                 if(ch == 'S'){
//                     startR = i;
//                     startC = j;
//                 }else if(ch == 'L') litterId[i][j] = litterCount++;
//             }
//         }
//         int targetMask = (1 << litterCount) -1;
//         Queue<int[]> queue = new LinkedList<>();
//         boolean[][][][] visited = new boolean[m][n][1 << litterCount][energy + 1];
//         queue.offer(new int[]{startR, startC, energy, 0});
//         visited[startR][startC][0][energy] = true;
//         int[][] direction = {{1,0}, {-1,0}, {0,-1},{0,1}};
//         int moves = 0;
//         while(!queue.isEmpty()){
//             int size = queue.size();
//             while(size-- > 0){
//                 int[] state = queue.poll();
//                 int r = state[0];
//                 int c = state[1];
//                 int currEnergy = state[2];
//                 int mask = state[3];
//                 if(mask == targetMask) return moves;
//                 for(int[] dir : direction){
//                     int nr = r + dir[0];
//                     int nc = c + dir[1];
//                     //outside the grid
//                     if(nr < 0 || nr >= m || nc < 0 || nc >=n) continue;
//                     // obstacle
//                     if(classroom[nr].charAt(nc) == 'X') continue;
//                     //energy zero
//                     if(currEnergy == 0) continue;
//                     int newEnergy = currEnergy -1;
//                     int newMask = mask;
//                     //collect litter
//                     if(litterId[nr][nc] != -1) newMask |= (1 << litterId[nr][nc]);
//                     if(classroom[nr].charAt(nc) == 'R') newEnergy = energy;
//                     if(!visited[nr][nc][newMask][newEnergy]){
//                         visited[nr][nc][newMask][newEnergy] = true;
//                         queue.offer(new int[]{nr, nc, newEnergy, newMask});
//                     }
//                 }
//             }
//             moves++;
//         }
//         return -1;
//     }
// }



class Solution{
    class node {
        int i, j, step, liter, energy;
        public node(int i, int j, int step, int liter, int energy){
            this.i = i;
            this.j = j;
            this.step = step;
            this.liter = liter;
            this.energy = energy;
        }
    }
    public int minMoves(String[] classroom, int e){
        int n = classroom.length, m = classroom[0].length(), x = -1, y = -1, l = 0;
        int[][] id = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                id[i][j] = -1;
                char ch = classroom[i].charAt(j);
                if(ch == 'S'){
                    x = i;
                    y = j;
                }
                if(ch == 'L'){
                    id[i][j] = l;
                    l++;
                }
            }
        }
        int total = 1 << l;
        int[][][] visited = new int[n][m][total];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                for(int k=0; k<total; k++){
                    visited[i][j][k] = -1;
                }
            }
        }
        Queue<node> pq = new LinkedList<>();
        pq.add(new node(x, y, 0, 0, e));
        visited[x][y][0] = e;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while(pq.size() > 0){
            node abc = pq.poll();
            int i = abc.i, j = abc.j, step = abc.step, liter = abc.liter, energy = abc.energy;
            if(classroom[i].charAt(j) == 'L'){
                int idd = id[i][j];
                liter = liter | (1 << idd);
            }
            if(liter == total -1) return step;
            if(classroom[i].charAt(j) == 'R') energy = e;
            if(energy == 0) continue;
            for(int d=0; d<4; d++){
                int ni = i + dx[d];
                int nj = j + dy[d];
                if(ni < 0 || ni >= n || nj < 0 || nj >= m) continue;
                if(classroom[ni].charAt(nj) == 'X') continue;
                int newEnergy = energy -1;
                int newLiter = liter;
                if(classroom[ni].charAt(nj) == 'R') newEnergy = e;
                if(visited[ni][nj][newLiter] >= newEnergy) continue;
                visited[ni][nj][newLiter] = newEnergy;
                pq.add(new node(ni, nj, step+1, newLiter, newEnergy));
            }
        }
        return -1;
    }
}
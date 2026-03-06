// class Solution {
//     public void solve(char[][] board) {
//         if(board==null || board.length==0){
//             return;
//         }
//         int m=board.length, n=board[0].length;
//         for(int r=0; r<m; r++){
//             for(int c=0; c<n; c++){
//                 if((r==0 || r == m-1 || c==0 || c==n-1) && board[r][c]=='O'){
//                     dfs(board, r, c);
//                 }
//             }
//         }
//         for(int r=0 ; r<m; r++){
//             for(int c=0; c<n; c++){
//                 if(board[r][c]=='O'){
//                     board[r][c]='X';
//                 }
//                 else if(board[r][c]=='T'){
//                     board[r][c]='O';
//                 }
//             }
//         }
//     }
//     private void dfs(char[][] board, int r, int c){
//     if(r < 0 || r>=board.length || c<0 || c>=board[0].length || board[r][c] !='O'){  //out of bound
//             return;
//         }
//         board[r][c]='T';
//         dfs(board, r+1, c);
//         dfs(board, r, c+1);
//         dfs(board, r-1, c);
//         dfs(board, r, c-1);
//     }
// }


// piyush
class Solution{
    public void solve(char[][] board){
        if(board.length==0 || board==null) return;
        int m=board.length, n=board[0].length;
        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                if((r==0 || r==m-1 || c==0 || c==n-1) && board[r][c]=='O'){
                    dfs(board, r, c, m, n);
                }
            }
        }
        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                if(board[r][c]=='O') board[r][c]='X';
                if(board[r][c]=='T') board[r][c]='O';
            }
        }
    }
    private void dfs(char[][] board, int r, int c, int m, int n){
        if(r<0 || r>=m || c<0 || c>=n || board[r][c]!='O'){
            return;
        }
        board[r][c]='T';
        dfs(board, r+1, c, m, n);
        dfs(board, r-1, c, m, n);
        dfs(board, r, c+1, m, n);
        dfs(board, r, c-1, m, n);
    }
}
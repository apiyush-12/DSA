// class Solution {
//     public List<List<String>> solveNQueens(int n) {
//         char[][] board=new char[n][n];
//         for(int i=0; i<n; i++){
//             for(int j=0; j<n; j++){
//                 board[i][j]='.';
//             }
//         }
//         List<List<String>> result=new ArrayList<>();
//         backTrack(result, board, 0);
//         return result;
//     }
//     private void backTrack(List<List<String>> result, char[][] board, int col){
//         if(col==board.length){
//             result.add(construct(board));
//             return;
//         }
//         for(int i=0; i<board.length; i++){
//             if(isValid(board, i, col)){
//                 board[i][col]='Q';
//                 backTrack(result, board, col+1);
//                 board[i][col]='.';
//             }
//         }
//     } 
//     private boolean isValid(char[][] board, int row, int col){
//         for(int i=0; i<col; i++){                    //left row
//             if(board[row][i]=='Q'){
//                 return false;
//             }
//         }
//         for(int i=row, j=col; i>=0 && j>=0; i--, j--){      //upper-left diagonal
//             if(board[i][j]=='Q'){
//                 return false;
//             }
//         }
//         for(int i=row, j=col; i<board.length && j>=0; i++, j--){       //lower-left diagonal
//             if(board[i][j]=='Q'){
//                 return false;
//             }
//         }
//         return true;
//     }
//     private List<String> construct(char[][] board){
//         List<String> result=new ArrayList<>();
//         for(int i=0; i<board.length; i++){
//             String row=new String(board[i]);
//             result.add(row);
//         }
//         return result;
//     }
// }


class Solution{
    // piyush
    public List<List<String>> solveNQueens(int n){
        List<List<String>> result=new ArrayList<>();
        int[] queens=new int[n];
        boolean[] cols=new boolean[n];
        boolean[] diag1=new boolean[2*n-1];
        boolean[] diag2=new boolean[2*n-1];
        backTrack(result, queens, 0, n, cols, diag1, diag2);
        return result;
    } 
    private void backTrack(List<List<String>> result, int[] queens, int row, int n, boolean[] cols, boolean[] diag1, boolean[] diag2){
        if(row==n){
            List<String> board=new ArrayList<>();
            for(int r=0; r<n; r++){
                char[] chars=new char[n];
                for(int c=0; c<n; c++){
                    chars[c]=(queens[r]==c) ? 'Q':'.';
                }
                board.add(new String(chars));
            }
            result.add(board);
            return;
        }

        for(int col=0; col<n; col++){
            int d1=row-col+n-1;
            int d2=row+col;
            if(cols[col] || diag1[d1] || diag2[d2]) continue;
            queens[row]=col;
            cols[col]=true;
            diag1[d1]=true;
            diag2[d2]=true;

            backTrack(result, queens, row+1, n, cols, diag1, diag2);

            cols[col]=false;
            diag1[d1]=false;
            diag2[d2]=false;
        }
    }
}
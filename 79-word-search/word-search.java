// class Solution {
//     public char[][] board;
//     public int rows;
//     public int cols;
//     public boolean exist(char[][] board, String word) {
//         this.board=board;
//         this.rows=board.length;
//         this.cols=board[0].length;

//         for(int r=0; r<rows; r++){
//             for(int c=0; c<cols; c++){
//                 if(backTrack(r, c, word, 0)){      //true
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
//     public boolean backTrack(int row, int col, String word, int index){
//         if(index>=word.length()){
//             return true;
//         }
//         if(row<0 || row>=rows || col<0 || col>=cols || this.board[row][col]!=word.charAt(index)){
//             return false;
//         }
//         int[] rowdir={0,1,0,-1};
//         int[] coldir={1,0,-1,0};
//         this.board[row][col]='#';

//         boolean ret=false;
//         for(int d=0; d<4; d++){
//             ret=backTrack(row+rowdir[d], col+coldir[d], word, index+1);
//             if(ret){   //true
//                 break;
//             }
//         }
//         board[row][col]=word.charAt(index);
//         return ret;
//     }
// }


// piyush
// class Solution {
//     private boolean find(char[][]board, String words, int indx, int r, int c) {
//         if(r<0 || r>=board.length || c<0 || c>=board[0].length || words.charAt(indx) != board[r][c])
//             return false;
//         if(indx == words.length()-1) return true;

//         char cur = board[r][c];
//         board[r][c] = '#';
//         boolean found = find(board, words, indx+1, r+1, c) || 
//                         find(board, words, indx+1, r, c+1) || 
//                         find(board, words, indx+1, r-1, c) || 
//                         find(board, words, indx+1, r, c-1);
//         board[r][c] = cur;
//         return found;        
//     }
//     public boolean exist(char[][] board, String word) {
//         int m = board.length, n= board[0].length;

//         for(int i=0; i<m; i++) {
//             for(int j=0; j<n; j++) {
//                 if(word.charAt(0) == board[i][j] && find(board, word, 0, i, j))
//                     return true;
//             }
//         }

//         return false;
//     }
// }


class Solution{
    public boolean exist(char[][] board, String word){
        int m=board.length, n=board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(word.charAt(0)==board[i][j] && backTrack(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backTrack(char[][]board, String word, int r, int c, int index){
        if(r<0 || r>=board.length || c<0 || c>=board[0].length || word.charAt(index)!=board[r][c]){
            return false;
        }
        if(index==word.length()-1){
            return true;
        }
        char curr=board[r][c];
        board[r][c]='#';
        boolean found= backTrack(board, word, r+1, c, index+1) ||
                       backTrack(board, word, r, c+1, index+1) ||
                       backTrack(board, word, r-1, c, index+1) ||
                       backTrack(board, word, r, c-1, index+1);
        board[r][c]=curr;
        return found;
    }
}
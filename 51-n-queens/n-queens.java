class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j]='.';
            }
        }
        List<List<String>> result=new ArrayList<>();
        backTrack(result, board, 0);
        return result;
    }
    private void backTrack(List<List<String>> result, char[][] board, int col){
        if(col==board.length){
            result.add(construct(board));
            return;
        }
        for(int i=0; i<board.length; i++){
            if(isValid(board, i, col)){
                board[i][col]='Q';
                backTrack(result, board, col+1);
                board[i][col]='.';
            }
        }
    } 
    private boolean isValid(char[][] board, int row, int col){
        for(int i=0; i<col; i++){
            if(board[row][i]=='Q'){
                return false;
            }
        }

        for(int i=row, j=col; i>=0 && j>=0; i--, j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        for(int i=row, j=col; i<board.length && j>=0; i++, j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    private List<String> construct(char[][] board){
        List<String> result=new ArrayList<>();
        for(int i=0; i<board.length; i++){
            String row=new String(board[i]);
            result.add(row);
        }
        return result;
    }
}
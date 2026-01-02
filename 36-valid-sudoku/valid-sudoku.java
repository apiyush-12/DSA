class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N=9;
        HashSet<Character>[] rows=new HashSet[N];
        HashSet<Character>[] cols=new HashSet[N];
        HashSet<Character>[] boxes=new HashSet[N];
        for(int i=0; i<N; i++){
            rows[i]=new HashSet<Character>();
            cols[i]=new HashSet<Character>();
            boxes[i]=new HashSet<Character>();
        }
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                char val=board[r][c];
                if(val=='.'){
                    continue;
                }
                if(rows[r].contains(val)){      //to check rows
                    return false;
                }
                rows[r].add(val);
                if(cols[c].contains(val)){   //to check columns
                    return false;
                }
                cols[c].add(val);
                int idx=r/3 * 3 + c/3;    //to check boxes
                if(boxes[idx].contains(val)){
                    return false;
                }
                boxes[idx].add(val);
            }
        }
        return true;
    }
}
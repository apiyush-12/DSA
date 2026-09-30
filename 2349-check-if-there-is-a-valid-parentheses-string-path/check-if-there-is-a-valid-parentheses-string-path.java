// class Solution {
//     public boolean hasValidPath(char[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
//         int len = m + n - 1;
//         // Valid parentheses string must have even length
//         if (len % 2 == 1) {
//             return false;
//         }
//         // Maximum useful balance is len
//         boolean[][][] dp = new boolean[m][n][len + 1];
//         // Starting cell must be '('
//         if (grid[0][0] == ')') {
//             return false;
//         }
//         dp[0][0][1] = true;
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (i == 0 && j == 0) {
//                     continue;
//                 }
//                 for (int balance = 0; balance <= len; balance++) {
//                     int previousBalance;
//                     if (grid[i][j] == '(') {
//                         previousBalance = balance - 1;
//                     } else {
//                         previousBalance = balance + 1;
//                     }

//                     if (previousBalance < 0 || previousBalance > len) {
//                         continue;
//                     }
//                     // Come from top
//                     if (i > 0 && dp[i - 1][j][previousBalance]) {
//                         dp[i][j][balance] = true;
//                     }
//                     // Come from left
//                     if (j > 0 && dp[i][j - 1][previousBalance]) {
//                         dp[i][j][balance] = true;
//                     }
//                 }
//             }
//         }
//         return dp[m - 1][n - 1][0];
//     }
// }

// class Solution {
//     public boolean hasValidPath(char[][] grid) {
//         int m = grid.length, n = grid[0].length;
//         if ((m + n - 1) % 2 != 0)
//             return false;
//         if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(')
//             return false;
//         Boolean[][][] memo = new Boolean[m][n][m + n];
//         return dfs(grid, 0, 0, 0, memo);
//     }

//     private boolean dfs(char[][] grid, int i, int j, int balance, Boolean[][][] memo) {
//         int m = grid.length, n = grid[0].length;
//         balance += grid[i][j] == '(' ? 1 : -1;
//         if (balance < 0)
//             return false;
//         if (i == m - 1 && j == n - 1)
//             return balance == 0;
//         if (memo[i][j][balance] != null)
//             return memo[i][j][balance];
//         boolean res = false;
//         if (i + 1 < m)
//             res |= dfs(grid, i + 1, j, balance, memo);
//         if (!res && j + 1 < n)
//             res |= dfs(grid, i, j + 1, balance, memo);
//         memo[i][j][balance] = res;
//         return res;
//     }
// }


class Solution{
    public boolean hasValidPath(char[][] grid){
        int m = grid.length, n = grid[0].length;
        if((m+n-1) % 2 != 0) return false;
        if(grid[0][0] == ')' || grid[m-1][n-1] == '(') return false;
        Boolean[][][] memo = new Boolean[m][n][m+n];
        return dfs(grid, 0, 0, 0, memo);
    }
    private boolean dfs(char[][] grid, int i, int j, int balance, Boolean[][][] memo){
        int m = grid.length, n = grid[0].length;
        balance += grid[i][j] == '(' ? 1 : -1;
        if(balance < 0) return false;
        if(i==m-1 && j==n-1) return balance == 0;
        if(memo[i][j][balance] != null) return memo[i][j][balance];
        boolean res = false;
        if(i + 1 < m) res |= dfs(grid, i+1, j, balance, memo);
        if(!res && j+1 < n) res |= dfs(grid, i, j+1, balance, memo);
        memo[i][j][balance] = res;
        return res;
    }
}
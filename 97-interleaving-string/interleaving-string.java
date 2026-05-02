// class Solution {
//     public boolean isInterleave(String s1, String s2, String s3) {
//         int m = s1.length();
//         int n = s2.length();
//         int l = s3.length();
//         if(m+n != l) return false;
//         boolean[][] dp = new boolean[m+1][n+1];
//         dp[0][0] = true;
//         for(int i=1; i<=m; i++){
//             dp[i][0] = dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
//         }
//         for(int i=1; i<=n; i++){
//             dp[0][i] = dp[0][i-1] && s2.charAt(i-1) == s3.charAt(i-1);
//         }
//         for(int i=1; i<=m; i++){
//             for(int j=1; j<=n; j++){
//                 dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1) || 
//                             dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
//             }
//         }
//         return dp[m][n];
//     }
// }


// class Solution{
//     Boolean[][] dp;
//     public boolean isInterleave(String s1, String s2, String s3){
//         int m=s1.length();
//         int n=s2.length();
//         int l=s3.length();
//         if(m + n != l) return false;
//         dp=new Boolean[m+1][n+1];
//         return solve(s1, s2, s3, 0, 0, m, n, l);
//     }
//     private boolean solve(String s1, String s2, String s3, int i, int j, int m, int n, int l){
//         if(i==m && j == n) return true;
//         if(dp[i][j] != null) return dp[i][j];
//         char c = s3.charAt(i+j);
//         boolean ans = false;
//         if(i<m && s1.charAt(i) == c) ans = solve(s1, s2, s3, i+1, j, m, n, l);
//         if(!ans && j < n && s2.charAt(j) == c) ans = solve(s1, s2, s3, i, j+1, m, n, l);
//         return dp[i][j] = ans;
//     }
// }


class Solution{
    Boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3){
        int m = s1.length();
        int n = s2.length();
        int l = s3.length();
        if(m+n != l) return false;
        dp = new Boolean[m+1][n+1];
        return solve(s1, s2, s3, 0, 0, m, n, l); 
    }
    private boolean solve(String s1, String s2, String s3, int i, int j, int m, int n, int l){
        if(i==m && j ==n) return true;
        if(dp[i][j] != null) return dp[i][j];
        char c = s3.charAt(i+j);
        boolean ans = false;
        if(i<m && s1.charAt(i) == c) ans = solve(s1, s2, s3, i+1, j, m, n, l);
        if(!ans && j<n && s2.charAt(j) == c) ans = solve(s1, s2, s3, i, j+1, m, n, l);
        return dp[i][j] = ans;
    }
}
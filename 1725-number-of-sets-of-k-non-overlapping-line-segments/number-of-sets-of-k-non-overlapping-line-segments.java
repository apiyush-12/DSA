class Solution {
    public static final int MOD = 1_000_000_007;
    public int numberOfSets(int n, int k) {
        int[][] dp = new int[k+1][n+1];
        for(int pos = 0; pos <= n; pos++) dp[0][pos] = 1;
        for(int segments = 1; segments <= k; segments++){
            int[] prevRowSum = new int[n+1];
            for(int pos = n-1; pos >= 0; pos--){
                prevRowSum[pos] = (int)((prevRowSum[pos + 1] + dp[segments-1][pos]) % MOD);
            }
            for(int pos = n-1; pos>=0; pos--){
                long ways = dp[segments][pos + 1];
                ways += prevRowSum[pos + 1];
                dp[segments][pos] = (int) (ways % MOD);
            }
        }
        return dp[k][0];
    }
}
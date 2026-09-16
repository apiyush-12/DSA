// class Solution {
//     public static final int MOD = 1_000_000_007;
//     public int numberOfSets(int n, int k) {
//         int[][] dp = new int[k+1][n+1];
//         for(int pos = 0; pos <= n; pos++) dp[0][pos] = 1;
//         for(int segments = 1; segments <= k; segments++){
//             int[] prevRowSum = new int[n+1];
//             for(int pos = n-1; pos >= 0; pos--){
//                 prevRowSum[pos] = (int)((prevRowSum[pos + 1] + dp[segments-1][pos]) % MOD);
//             }
//             for(int pos = n-1; pos>=0; pos--){
//                 long ways = dp[segments][pos + 1];
//                 ways += prevRowSum[pos + 1];
//                 dp[segments][pos] = (int) (ways % MOD);
//             }
//         }
//         return dp[k][0];
//     }
// }



class Solution {

    private static final long MOD = 1000000007L;

    private long quickPow(long a, long e) {
        long result = 1;
        while (e > 0) {
            if ((e & 1) != 0) result = (result * a) % MOD;
            a = (a * a) % MOD;
            e >>= 1;
        }
        return result;
    }

    public int numberOfSets(int n, int k) {
        int m = 2 * k;
        long numerator = 1, denominator = 1;
        for (int i = 1; i <= m; i++) {
            numerator = (numerator * (n + k - i)) % MOD;
            denominator = (denominator * i) % MOD;
        }
        return (int) ((numerator * quickPow(denominator, MOD - 2)) % MOD);
    }
}
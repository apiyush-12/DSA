// class Solution {
//     public int zigZagArrays(int n, int l, int r) {
//         int k = r-l+1;
//         int MOD = 1000000007;
//         int[][] dp = new int[k+1][2];
//         for(int v = 1; v<=k; v++){
//             dp[v][0]= k - v;
//             dp[v][1]= v-1;
//         }

//         for(int i=3; i<=n; i++){
//             int[][] nextDp = new int[k+1][2];
//             long runSum0 = 0;
//             for(int v=1; v<=k; v++){
//                 nextDp[v][1] = (int) runSum0;
//                 runSum0 = (runSum0 + dp[v][0]) % MOD;
//             }
//             long runSum1 = 0;
//             for(int v=k; v>=1; v--){
//                 nextDp[v][0] = (int) runSum1;
//                 runSum1 = (runSum1 + dp[v][1]) % MOD;
//             }
//             dp = nextDp;
//         }

//         long total =0;
//         for(int v=1; v<=k; v++){
//             total = (total + dp[v][0]) % MOD;
//             total = (total + dp[v][1]) % MOD;
//         }
//         return (int) total;
//     }
// }


class Solution {
       public int zigZagArrays(int n, int l, int r) {
        int MOD = 1_000_000_007;
        r -= l;
        int[] dp = new int[r + 1];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            int pre = 0, pre2;
            if ((i & 1) == 1) {
                for (int v = 0; v <= r; v++) {
                    pre2 = pre + dp[v];
                    dp[v] = pre;
                    pre = pre2 % MOD;
                }
            } else {
                for (int v = r; v >= 0; v--) {
                    pre2 = pre + dp[v];
                    dp[v] = pre;
                    pre = pre2 % MOD;
                }
            }
        }
        int res = 0;
        for (int v : dp)
            res = (res + v) % MOD;
        return res * 2 % MOD;
    }
}
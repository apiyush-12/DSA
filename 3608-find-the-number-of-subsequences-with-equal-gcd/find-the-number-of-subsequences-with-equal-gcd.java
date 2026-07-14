// class Solution {
//     int MOD = 1_000_000_007;
//     int[][][] memo;
//     int[] nums;
//     int n;
//     public int subsequencePairCount(int[] nums) {
//         this.nums = nums;
//         n = nums.length;
//         memo = new int[n+1][201][201];
//         for(int i=0; i<=n; i++){
//             for(int j=0; j<=200; j++){
//                 Arrays.fill(memo[i][j], -1);
//             }
//         }
//         return dfs(0, 0, 0);
//     }
//     private int dfs(int idx, int g1, int g2){
//         if(idx == n) return (g1>0 && g2>0 && g1==g2) ? 1 : 0;
//         if(memo[idx][g1][g2] != -1) return memo[idx][g1][g2];
//         long ans =0;
//         ans += dfs(idx+1, g1, g2);
//         ans += dfs(idx+1, gcd(g1, nums[idx]), g2);
//         ans += dfs(idx+1, g1, gcd(g2, nums[idx]));
//         return memo[idx][g1][g2] = (int)(ans%MOD);
//     }
//     private int gcd(int a, int b){
//         if(a==0) return b;
//         return gcd(b%a, a);
//     }
// }


class Solution {
    static final int MOD = 1000000007;
    public int subsequencePairCount(int[] nums) {
        int m = 0;
        for (int num : nums) {
            m = Math.max(m, num);
        }
        int[][] dp = new int[m + 1][m + 1];
        dp[0][0] = 1;

        for (int num : nums) {
            int[][] ndp = new int[m + 1][m + 1];
            for (int j = 0; j <= m; j++) {
                int divisor1 = gcd(j, num);
                for (int k = 0; k <= m; k++) {
                    int val = dp[j][k];
                    if (val == 0) {
                        continue;
                    }
                    int divisor2 = gcd(k, num);
                    ndp[j][k] = (ndp[j][k] + val) % MOD;
                    ndp[divisor1][k] = (ndp[divisor1][k] + val) % MOD;
                    ndp[j][divisor2] = (ndp[j][divisor2] + val) % MOD;
                }
            }
            dp = ndp;
        }

        int ans = 0;
        for (int j = 1; j <= m; j++) {
            ans = (ans + dp[j][j]) % MOD;
        }
        return ans;
    }

    private int gcd(int a, int b) {
        if(a==0) return b;
        return gcd(b%a, a);
    }
}
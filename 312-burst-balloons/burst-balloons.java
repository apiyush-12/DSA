// class Solution {
//     public int maxCoins(int[] nums) {
//         int n = nums.length;
//         int[] extNums = new int[n+2];
//         extNums[0] = 1;
//         extNums[n+1] = 1;
//         for(int i=1; i<=n; i++) extNums[i] = nums[i-1];
//         int[][] dp = new int[n+2][n+2];
//         for(int i=1; i<=n; i++){
//             for(int left=1; left<=n-i+1; left++){
//                 int right = left+i-1;
//                 for(int k=left; k<=right; k++){
//                     int coins = extNums[left-1] * extNums[k] * extNums[right+1];
//                     coins += dp[left][k-1] + dp[k+1][right];
//                     dp[left][right] = Math.max(dp[left][right], coins);
//                 }
//             }
//         }
//         return dp[1][n];
//     }
// }

class Solution{
    public int maxCoins(int[] nums){
        int n = nums.length;
        int[] extLen = new int[n+2];
        extLen[0] = 1;
        extLen[n+1] = 1;
        for(int i=1; i<=n; i++){
            extLen[i] = nums[i-1];
        }
        int[][] dp = new int[n+2][n+2];
        for(int i=1; i<=n; i++){
            for(int left = 1; left <=n-i+1; left++){
                int right = left+i-1;
                for(int j=left; j<=right; j++){
                    int coins = extLen[left-1] * extLen[j] * extLen[right+1];
                    coins += dp[left][j-1] + dp[j+1][right];
                    dp[left][right] = Math.max(dp[left][right], coins);
                }
            }
        }
        return dp[1][n];
    }
}
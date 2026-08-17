// class Solution {
//     public int stoneGameV(int[] stoneValue) {
//         int n = stoneValue.length;
//         int[] prefix = new int[n+1];
//         for(int i=0; i<n; i++) prefix[i+1] = prefix[i] + stoneValue[i];
//         int[][] dp = new int[n][n];
//         for(int len = 2; len <= n; len++){
//             for(int l = 0; l + len <= n; l++){
//                 int r = l + len -1;
//                 for(int k=l; k<r; k++){
//                     int leftSum = prefix[k+1] - prefix[l];
//                     int rightSum = prefix[r+1] - prefix[k+1];
//                     if(leftSum < rightSum){
//                         dp[l][r] = Math.max(dp[l][r], leftSum + dp[l][k]);
//                     }else if(leftSum > rightSum){
//                         dp[l][r] = Math.max(dp[l][r], rightSum + dp[k+1][r]);
//                     }else{
//                         dp[l][r] = Math.max(dp[l][r], leftSum + Math.max(dp[l][k], dp[k+1][r]));
//                     }
//                 }
//             }
//         }
//         return dp[0][n-1];
//     }
// }


class Solution {
    int[][] dp = new int[501][501];
    int[] sum = new int[501];
    int solve(int l , int r){
        if(l>r) return 0;
        if(dp[l][r]!=-1) return dp[l][r];
        int ans = 0;
        for(int i=l; i<r; i++){
            int left = sum[i]-sum[l-1];
            int right = sum[r]-sum[i];
            if(left>right){
                ans = Math.max(ans,right+solve(i+1,r));
            }
            else if(left<right){
                ans = Math.max(ans,left+solve(l,i));
            }
            else{
                ans = Math.max(ans,right+solve(i+1,r));
                ans = Math.max(ans,right+solve(l,i));
            }
        }
        dp[l][r]=ans;
        return dp[l][r];
    }
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        for(int i=1; i<=n; i++){
            sum[i]=sum[i-1]+stoneValue[i-1];
        }
        for(int i=0; i<=n; i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(1,n);
    }
}
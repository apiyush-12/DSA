// class Solution {
//     public int climbStairs(int n, int[] costs) {
//         int[] dp = new int[n+1];
//         dp[0] = 0;
//         for(int i=1; i<=n; i++){
//             dp[i] = Integer.MAX_VALUE;
//             for(int j=1; j<=3; j++){
//                 if(i-j >= 0){
//                     int cost = dp[i-j] + costs[i-1] + j*j;
//                     dp[i] = Math.min(dp[i], cost); 
//                 }
//             }
//         }
//         return dp[n];
//     }
// }



class Solution {
    public int climbStairs(int n, int[] costs) {
        int a = 0, b = 0, c = 0;
        for (int cost : costs) {
            int z = Math.min(Math.min(a + 9, b + 4), c + 1) + cost;
            a = b;
            b = c;
            c = z;
        }
        return c;
    }
}
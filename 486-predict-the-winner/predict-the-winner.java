// class Solution {
//     Integer[][] dp;
//     public boolean predictTheWinner(int[] nums) {
//         int n = nums.length;
//         dp = new Integer[n][n];
//         return solve(nums, 0, n - 1) >= 0;
//     }
//     private int solve(int[] nums, int i, int j) {
//         if (i == j)
//             return nums[i];
//         if (dp[i][j] != null)
//             return dp[i][j];
//         int left = nums[i] - solve(nums, i + 1, j);
//         int right = nums[j] - solve(nums, i, j - 1);
//         return Math.max(left, right);
//     }
// }

// class Solution{
//     Integer dp[][];
//     public boolean predictTheWinner(int[] nums){
//         int n = nums.length;
//         dp = new Integer[n][n];
//         int total = 0;
//         for(int x : nums) total += x;
//         int p1 = solve(nums, 0, n-1);
//         int p2 = total - p1;
//         return p1 >= p2;
//     }
//     private int solve(int[] nums, int i, int j){
//         if(i>j) return 0;
//         if(i==j) return nums[i];
//         if(dp[i][j] != null) return dp[i][j];
//         int left = nums[i] + Math.min(solve(nums, i+1, j-1), solve(nums, i+2, j));
//         int right = nums[j] + Math.min(solve(nums, i+1, j-1), solve(nums, i, j-2));
//         return Math.max(left, right);
//     }
// }


class Solution {

    public boolean predictTheWinner(int[] nums) {
        
        int n = nums.length;
        int[] dp = nums.clone(); 
        
        for (int diff = 1; diff < n; ++diff) {
            for (int j = n - 1; j - diff >= 0; --j) {
                int i = j - diff;
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        
        return dp[n - 1] >= 0;
    }
}
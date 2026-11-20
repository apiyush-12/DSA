// class Solution {
//     public int maxSelectedElements(int[] nums) {
//         Arrays.sort(nums);
//         Map<Integer, Integer> dp = new HashMap<>();
//         int ans = 0;
//         for(int x : nums){
//             int len1 = dp.getOrDefault(x-1, 0) + 1;
//             int len2 = dp.getOrDefault(x, 0) + 1;

//             dp.put(x, Math.max(dp.getOrDefault(x, 0), len1));
//             dp.put(x+1, Math.max(
//                 dp.getOrDefault(x+1, 0), len2
//             ));
//             ans = Math.max(ans, Math.max(dp.get(x), dp.get(x+1)));
//         }
//         return ans;
//     }
// }



class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        int[] dp = new int[max + 3];
        int best = 0;
        for (int a : nums) {
            int b = a + 1;
            dp[b] = Math.max(dp[b], dp[b - 1] + 1);
            dp[a] = Math.max(dp[a], dp[a - 1] + 1);
            best = Math.max(best, Math.max(dp[a], dp[b]));
        }
        return best;
    }
}
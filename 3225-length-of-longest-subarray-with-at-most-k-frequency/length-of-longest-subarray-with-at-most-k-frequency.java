// class Solution {
//     public int maxSubarrayLength(int[] nums, int k) {
//         int n = nums.length;
//         int left = 0, right = 0, maxLen = 0, overCount = 0;
//         Map<Integer, Integer> map = new HashMap<>();
//         while(right < n){
//             int currNum = nums[right];
//             map.put(currNum, map.getOrDefault(currNum, 0)+1);
//             if(map.get(currNum) == k+1) overCount++;
//             if(overCount > 0){
//                 int leftNum = nums[left];
//                 map.put(leftNum, map.get(leftNum)-1);
//                 if(map.get(leftNum) == k) overCount--;
//                 left++;
//             }
//             if(overCount == 0) maxLen = Math.max(maxLen, (right-left)+1);
//             right++;
//         }
//         return maxLen;

//     }
// }


// class Solution {
//   public int maxSubarrayLength(int[] nums, int k) {
//     int ans = 0;
//     Map<Integer, Integer> count = new HashMap<>();

//     for (int l = 0, r = 0; r < nums.length; ++r) {
//       count.merge(nums[r], 1, Integer::sum);
//       while (count.get(nums[r]) == k + 1)
//         count.merge(nums[l++], -1, Integer::sum);
//       ans = Math.max(ans, r - l + 1);
//     }
//     return ans;
//   }
// }


class Solution{
    public int maxSubarrayLength(int[] nums, int k){
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int l = 0, r = 0; r<nums.length; r++){
            map.merge(nums[r], 1, (a, b)-> a+b);
            while(map.get(nums[r])==k+1){
                map.merge(nums[l++], -1, Integer::sum);
            }
            ans = Math.max(ans, (r-l)+1);
        }
        return ans;
    }
}
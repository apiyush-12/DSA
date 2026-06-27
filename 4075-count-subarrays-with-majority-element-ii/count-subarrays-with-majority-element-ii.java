// class Solution {
//     public long countMajoritySubarrays(int[] nums, int target) {
//         int n = nums.length;
//         int len = 2*n+2;
//         long[] countAtSum = new long[len];
//         long[] cumSum = new long[len];
//         int idx = n+1;
//         countAtSum[idx] = 1;
//         cumSum[idx] = 1;
//         long ans = 0;
//         for(int num : nums){
//             if(num == target) idx++;
//             else idx--;
//             countAtSum[idx]++;
//             ans += cumSum[idx-1];
//             cumSum[idx] = cumSum[idx-1]+countAtSum[idx];
//         }
//         return ans;
//     }
// }

// class Solution {
//     public long countMajoritySubarrays(int[] nums, int target) {
//         int n = nums.length;
//         // represents the occurrence count of prefix sums -n, -(n-1), ..., 0, 1, ..., n, with index offset by n.
//         int[] pre = new int[n * 2 + 1];
//         pre[n] = 1;
//         int cnt = n;
//         long ans = 0;
//         long presum = 0;
//         for (int i = 0; i < n; ++i) {
//             if (nums[i] == target) {
//                 presum += pre[cnt];
//                 ++cnt;
//                 ++pre[cnt];
//             } else {
//                 --cnt;
//                 presum -= pre[cnt];
//                 ++pre[cnt];
//             }
//             ans += presum;
//         }
//         return ans;
//     }
// }


class Solution{
    public long countMajoritySubarrays(int[] nums, int target){
        int n = nums.length;
        int[] pre = new int[2*n+1];
        pre[n] = 1;
        int cnt = n;
        long ans = 0;
        long preSum = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == target){
                preSum += pre[cnt];
                cnt++;
                pre[cnt]++;
            }else{
                cnt--;
                preSum -= pre[cnt];
                pre[cnt]++;
            }
            ans += preSum;
        }
        return ans;
    }
}
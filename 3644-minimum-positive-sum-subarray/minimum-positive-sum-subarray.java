// class Solution {
//     public int minimumSumSubarray(List<Integer> nums, int l, int r) {
//         int n = nums.size();
//         int ans = Integer.MAX_VALUE;
//         for(int i=0; i<n; i++){
//             int sum = 0;
//             for(int j=i; j<n; j++){
//                 sum += nums.get(j);
//                 int length = j-i+1;
//                 if(length >= l && length <= r){
//                     if(sum > 0){
//                         ans = Math.min(ans, sum);
//                     }
//                 }
//                 if(length >= r) break;
//             }
//         }
//         return ans == Integer.MAX_VALUE ? -1 : ans;
//     }
// }



class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums.get(i);
        }
        int minSum = Integer.MAX_VALUE;
        for (int length = l; length <= r; length++) {
            for (int start = 0; start + length <= n; start++) {
                int sum = prefixSum[start + length] - prefixSum[start];
                if (sum > 0 && sum < minSum) {
                    minSum = sum;
                }
            }
        }
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}
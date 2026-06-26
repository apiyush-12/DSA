// class Solution {
//     public int countMajoritySubarrays(int[] nums, int target) {
//         int n = nums.length, count = 0;
//         for(int i=0; i<n; i++){
//             int tempCount = 0;
//             for(int j=i; j<n; j++){
//                 if(nums[j] == target) tempCount++;
//                 if(tempCount * 2 > j-i+1) count++;
//             }
//         }
//         return count;
//     }
// }

// class Solution {
//     public int countMajoritySubarrays(int[] nums, int target) {
//         int n = nums.length;
//         int pos = n+1;
//         int len = 2*n+2;
//         int[] freq = new int[len];
//         int[] cum = new int[len];
//         freq[pos] = 1;
//         cum[pos] = 1;
//         int count = 0;
//         for(int num: nums) {
//             int offset = (num == target) ? 1 : -1;
//             pos += offset;
//             freq[pos]++;
//             cum[pos] = cum[pos-1] + freq[pos];
//             count += cum[pos-1];
//         }
//         return count;
//     }
// }


class Solution{
    public int countMajoritySubarrays(int[] nums, int target){
        int n = nums.length;
        int pos = n+1;
        int len = 2*n+2;
        int[] freq = new int[len];
        int[] cum = new int[len];
        freq[pos] = 1;
        cum[pos] = 1;
        int count=0;
        for(int num : nums){
            int offset = (num == target) ? 1 : -1;
            pos += offset;
            freq[pos]++;
            cum[pos] = cum[pos-1] + freq[pos];
            count += cum[pos-1];
        }
        return count;
    }
}
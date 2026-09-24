// class Solution {
//     public int minOperations(int[] nums, int x) {
//         int n = nums.length;
//         long totalSum = 0;
//         for(int num : nums) totalSum += num;
//         long target = totalSum - x;
//         if(target < 0) return -1;
//         int left = 0;
//         long windowSum = 0;
//         int maxLength = -1;
//         for(int right=0; right < n; right++){
//             windowSum += nums[right];
//             while(left <= right && windowSum > target){
//                 windowSum -= nums[left];
//                 left++;
//             }
//             if(windowSum == target) maxLength = Math.max(maxLength, right-left+1);
//         }
//         if(maxLength == -1) return -1;
//         return n - maxLength;
//     }
// }



class Solution{
    public int minOperations(int[] nums, int x){
        int totalSum = 0;
        for(int num : nums) totalSum += num;
        x = totalSum - x;
        if(x < 0) return -1;
        else if(x==0) return nums.length;
        int start = 0;
        int end = 0;
        int maxLength=0;
        int sum = 0;
        while(end < nums.length){
            sum += nums[end];
            while(sum >= x){
                if(sum==x) maxLength = Math.max(maxLength, end - start +1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return maxLength == 0 ? -1 : nums.length - maxLength;
    }
}
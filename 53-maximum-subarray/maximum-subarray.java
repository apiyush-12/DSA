// class Solution {
    // public int maxSubArray(int[] nums) {
    //     int currSum=nums[0];
    //     int maxSum=nums[0];
    //     for(int i=1; i<nums.length; i++){
    //         if(currSum+nums[i]>nums[i]){
    //             currSum+=nums[i];
    //         }else{
    //             currSum=nums[i];
    //         }
    //         maxSum=Math.max(currSum, maxSum);
    //     }
    //     return maxSum;
    // }


    // piyush //
//     public int maxSubArray(int []  nums){
//         int currSum=nums[0];
//         int maxSum=nums[0];
//         for(int i=1; i<nums.length; i++){
//             if(currSum+nums[i]>nums[i]){
//                 currSum+=nums[i];
//             }else{
//                 currSum=nums[i];
//             }
//             maxSum=Math.max(currSum, maxSum);
//         }
//         return maxSum;
//     }
// }

class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int max=nums[0];
        int sum=0;
        for(int i=0;i<n;i++){
            sum=nums[i]+sum;
            max = sum > max ? sum : max;
            sum = sum < 0 ? 0 : sum;
        }
        return max;
    }
}
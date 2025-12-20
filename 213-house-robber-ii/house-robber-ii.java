// class Solution {
//     public int rob(int[] nums) {
//         if(nums.length==1){
//             return nums[0];
//         }
//         int x=Max(nums, 0, nums.length-1);
//         int y=Max(nums, 1, nums.length);
//         return Math.max(x,y);
//     }
//     public int Max(int[] nums, int start, int end){
//         int rob1=0, rob2=0, max=0;
//         for(int i=start; i<end; i++){
//             max=Math.max(rob1+nums[i], rob2);
//             rob1=rob2;
//             rob2=max;
//         }
//         return max;
//     }
// }

// piyush
class Solution{
    public int rob(int[] nums){
        int max=0, rob1=0, rob2=0, max1=nums[0], max2=0;
        for(int i=0; i<nums.length-1; i++){
            max1=Math.max(rob1+nums[i], rob2);
            rob1=rob2;
            rob2=max1;
        }    
        rob1=0;
        rob2=0;
        for(int i=1; i<nums.length; i++){
            max2=Math.max(rob1+nums[i], rob2);
            rob1=rob2;
            rob2=max2;
        }
        return Math.max(max1, max2); 
    }
}
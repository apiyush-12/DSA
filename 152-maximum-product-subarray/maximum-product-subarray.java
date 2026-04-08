// class Solution {
//     public int maxProduct(int[] nums) {
//         if(nums.length==0) return 0;
//         int min = nums[0];
//         int max = nums[0];
//         int result = max;
//         for(int i=1; i<nums.length; i++){
//             int curr = nums[i];
//             int temp= Math.max(curr, Math.max(curr*min, curr*max));
//             min= Math.min(curr, Math.min(curr*min, curr*max));
//             max=temp;
//             result = Math.max(result, max);
//         }
//         return result;
//     }
// }


// class Solution {
//     public int maxProduct(int[] nums) {
//         int max = nums[0], min = nums[0], result = nums[0];
//         for (int i = 1; i < nums.length; i++) {
//             int curr = nums[i];
//             if (curr < 0) {
//                 int temp = max;
//                 max = min;
//                 min = temp;
//             }
//             max = Math.max(curr, curr * max);
//             min = Math.min(curr, curr * min);
//             result = Math.max(result, max);
//         }
//         return result;
//     }
// }

// class Solution{
//     public int maxProduct(int[] nums){
//         int max = nums[0], min=nums[0], ans=max;
//         for(int i=1; i<nums.length; i++){
//             int curr = nums[i];
//             if(curr < 0){
//                 int temp = max;
//                 max=min;
//                 min=temp;
//             }
//             max=Math.max(curr, curr*max);
//             min=Math.min(curr, curr*min);
//             ans = Math.max(ans, max);
//         }
//         return ans;
//     }
// }

class Solution{
    public int maxProduct(int[] nums){
        int pro=1;
        int max=Integer.MIN_VALUE;
        for(int i=nums.length-1; i>=0; i--){
            pro *= nums[i];
            if(pro > max){
                max=pro;
            }
            if(pro==0) pro=1;
        }
        pro=1;
        for(int i=0; i<nums.length; i++){
            pro *= nums[i];
            if(pro > max) max=pro;
            if(pro==0) pro=1;
        }
        return max;
    }
}
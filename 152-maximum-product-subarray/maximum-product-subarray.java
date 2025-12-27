// class Solution {
//     public int maxProduct(int[] nums) {
//         int minProduct=1;
//         int maxProduct=1;
//         int result=nums[0];
//         for(int i=0; i<nums.length; i++){
//             int temp=maxProduct*nums[i];
//             maxProduct=Math.max(nums[i], Math.max(maxProduct*nums[i], minProduct*nums[i]));
//             minProduct=Math.min(nums[i], Math.min(temp, minProduct*nums[i]));

//             result=Math.max(result, Math.max(maxProduct, minProduct));
//         }
//         return result;
//     }
// }

//2nd Method

// piyush
class Solution{
    public int maxProduct(int[] nums){
        int pro=1;
        int max=Integer.MIN_VALUE;
        for(int i=nums.length-1; i>=0; i--){
            pro*=nums[i];
            if(pro>max){
                max=pro;
            }
            if(pro==0){
                pro=1;
            }
        }
        pro=1;
        for(int i=0; i<nums.length; i++){
            pro*=nums[i];
            if(pro>max){
                max=pro;
            }
            if(pro==0){
                pro=1;
            }
        }
        return max;
    }
}
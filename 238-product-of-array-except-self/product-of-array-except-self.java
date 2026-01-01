// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int n=nums.length;
//         int pro=1;
//         int[] right=new int[n];
//         for(int i=n-1; i>=0; i--){
//             pro=pro*nums[i];
//             right[i]=pro;
//         }
//         int[] ans=new int[n];
//         int left=1;
//         for(int i=0; i<n-1; i++){
//             ans[i]=left*right[i+1];
//             left=left*nums[i];
//         }
//         ans[n-1]=left;
//         return ans;
//     }
// }

class Solution{
    public int[] productExceptSelf(int[] nums){
        int pro=1;
        int n=nums.length;
        int[] right=new int[n];
        for(int i=n-1; i>=0; i--){
            pro=pro*nums[i];
            right[i]=pro;
        }
        int[] ans=new int[n];
        int left=1;
        for(int i=0; i<n-1; i++){
            ans[i]=left*right[i+1];
            left=left*nums[i];
        }
        ans[n-1]=left;
        return ans;
    }
}
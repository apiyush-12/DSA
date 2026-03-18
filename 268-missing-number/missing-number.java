// class Solution {
//     public int missingNumber(int[] nums) {
//         int xor1=0;
//         int xor2=0;
//         int n=nums.length;
//         for(int i=0; i<n; i++){
//             xor1 ^= nums[i];
//         }
//         for(int i=0; i<=n; i++){
//             xor2 ^= i;
//         }
//         return xor1 ^ xor2;
//     }
// }

class Solution{
    public int missingNumber(int[] nums){
        int x=0;
        int y=0;
        for(int i=0; i<nums.length; i++){
            x ^= nums[i];
        }
        for(int i=0; i<=nums.length; i++){
            y ^= i;
        }
        return x^y;
    }
}


// public int missingNumber(int[] nums){
//         int n=nums.length;
//         int actualSum=(n*(n+1))/2;
//         int currSum=0;
//         for(int i=0; i<n; i++){
//             currSum=currSum+nums[i];
//         }
//         int ans=actualSum-currSum;
//         return ans;
//     }
// }
// class Solution {
//     public int longestMonotonicSubarray(int[] nums) {
//         int maxLength = 0;
//         for(int start=0; start<nums.length; start++){
//             int currLength = 1;
//             for(int pos=start + 1; pos<nums.length; pos++){
//                 if(nums[pos] > nums[pos-1]){
//                     currLength++;
//                 }else{
//                     break;
//                 }
//             }
//             maxLength = Math.max(maxLength, currLength);            
//         }
//         for(int start=0; start<nums.length; start++){
//             int currLength = 1;
//             for(int pos=start+1; pos<nums.length; pos++){
//                 if(nums[pos] < nums[pos-1]){
//                     currLength++;
//                 }else{
//                     break;
//                 }
//             }
//             maxLength = Math.max(maxLength, currLength);            
//         }
//         return maxLength;
//     }
// }

class Solution{
    public int longestMonotonicSubarray(int[] nums){
        int inc = 1;
        int dec = 1;
        int maxLength = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] > nums[i-1]){
                inc++;
                dec=1;
            }else if(nums[i] < nums[i-1]){
                dec++;
                inc=1;
            }else{
                dec=1;
                inc=1;
            }
            maxLength = Math.max(maxLength, Math.max(inc, dec));
        }
        return maxLength;
    }
}
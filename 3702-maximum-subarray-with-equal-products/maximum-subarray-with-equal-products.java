// class Solution{
//     public int maxLength(int[] nums){
//         int n = nums.length;
//         int maxLen = 1;
//         for(int i=0; i<n; i++){
//             long product = 1;
//             int gcd = nums[i];
//             long lcm = nums[i];
//             for(int j=i; j<n; j++){
//                 product *= nums[j];
//                 gcd = gcd(gcd, nums[j]);
//                 lcm = lcm(lcm, nums[j]);
//                 if(product == gcd*lcm){
//                     maxLen = Math.max(maxLen, j-i+1);
//                 }
//             }
//         }
//         return maxLen;
//     }

//     private int gcd(int a, int b){
//         while(b != 0){
//             int temp = b;
//             b = a % b;
//             a = temp;            
//         }
//         return a;
//     }

//     private long lcm(long a, long b){
//         return (a / gcd((int) a, (int) b)) * b;
//     }
// }



class Solution {
    public int maxLength(int[] nums) {
        int result = 2;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            for (int i = right - 1; i >= left; i--) {
                if (gcd(nums[i], nums[right]) > 1) {
                    left = i + 1;
                    break;
                }
            }

            result = Math.max(result, right - left + 1);
        }
        return result;
    }
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
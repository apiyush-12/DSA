// class Solution {
//     public int sumOfSquares(int[] nums) {
//         int n = nums.length;
//         int total = 0;
//         int i = 1;
//         for(int num : nums){
//             if(n % i == 0) total += num*num;
//             i +=1;
//         }
//         return total;
//     }
// }


class Solution{
    public int sumOfSquares(int[] nums){
        int n = nums.length;
        int total = 0;
        int i = 1;
        for(int num : nums){
            if(n % i == 0) total += num*num;
            i += 1;
        }
        return total;
    }
}
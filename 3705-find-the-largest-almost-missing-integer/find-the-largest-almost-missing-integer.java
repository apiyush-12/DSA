// class Solution {
//     public int largestInteger(int[] nums, int k) {
//         int[] count = new int[51];
//         if(nums.length == k){
//             int res = nums[0];
//             for(int x : nums){
//                 res = Math.max(res, x);
//             }
//             return res;
//         }
//         for(int i=0; i<=nums.length-k; i++){
//             boolean[] seen = new boolean[51];
//             for(int j=i; j<i+k; j++) seen[nums[j]] = true;
//             for(int num=0; num<=50; num++){
//                 if(seen[num]) count[num]++;
//             }
//         }

//         for(int i=50; i>=0; i--){
//             if(count[i] == 1) return i;
//         }
//         return -1;
//     }
// }


// class Solution {

//     public int largestInteger(int[] nums, int k) {
//         int n = nums.length;
//         if (n == k) {
//             int res = nums[0];
//             for (int x : nums) res = Math.max(res, x);
//             return res;
//         }
//         int[] count = new int[51];
//         for (int x : nums) count[x]++;
//         if (k == 1) {
//             for (int i = 50; i >= 0; --i) {
//                 if (count[i] == 1) {
//                     return i;
//                 }
//             }
//             return -1;
//         }
        
//         int res = -1;
//         if (count[nums[0]] == 1) {
//             res = Math.max(res, nums[0]);
//         }
//         if (count[nums[n - 1]] == 1) {
//             res = Math.max(res, nums[n - 1]);
//         }
//         return res;
//     }
// }

class Solution{
    public int largestInteger(int[] nums, int k){
        int n = nums.length;
        if(n==k){
            int res = nums[0];
            for(int i=1; i<n; i++){
                res = Math.max(res, nums[i]);
            }
            return res;
        }
        int[] count = new int[51];
        for(int x : nums) count[x]++;
        if(k==1){
            for(int i=50; i>=0; i--){
                if(count[i] == 1) return i;
            }
            return -1;
        }

        int res = -1;
        if(count[nums[0]] == 1){
            res = Math.max(res, nums[0]);
        }
        if(count[nums[n-1]] == 1){
            res = Math.max(res, nums[n-1]);
        }
        return res;
    }
}
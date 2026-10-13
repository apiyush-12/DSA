// class Solution {
//     public int maxSum(List<Integer> nums, int k) {
//         int MOD = 1_000_000_007;
//         int[] bits = new int[32];
//         for(int num : nums){
//             for(int b=0; b<32; b++){
//                 if((num & (1 << b)) != 0) bits[b]++;
//             }
//         }
//         long ans = 0;
//         for(int i=0; i<k; i++){
//             long num = 0;
//             for(int b=31; b>=0; b--){
//                 if(bits[b] > 0){
//                     num |= (1L << b);
//                     bits[b]--;
//                 }
//             }
//             ans = (ans + num * num) % MOD;
//         }
//         return (int) ans;
//     }
// }




// class Solution {
//     public int maxSum(List<Integer> nums, int k) {
//         int[] count = new int[32];
//         int mod = (int) (1e9 + 7);
//         for (int num : nums){
//             for (int i = 0; i < 32; ++i)
//                 count[i] += num >> i & 1;   
//         }
//         long ans = 0;
//         for (int i = 0; i < k; ++i){
//             int c = 0;
//             for (int j = 0; j < 32; ++j){
//                 if (count[j] == 0) continue;
//                 c |= 1 << j;
//                 --count[j];
//             }
//             ans = (ans + 1L * c * c) % mod;
//         }
//         return (int) ans;
//     }
// }


class Solution{
    public int maxSum(List<Integer> nums, int k){
        int[] count = new int[32];
        int mod = (int)(1e9 + 7);
        for(int num : nums){
            for(int i=0; i<32; i++){
                count[i] += num >> i & 1;
            }
        }
        long ans = 0;
        for(int i=0; i<k; i++){
            int c = 0;
            for(int j=0; j<32; j++){
                if(count[j] == 0) continue;
                c |= 1<< j;
                count[j]--;
            }
            ans = (ans + 1L * c * c) % mod;
        }
        return (int) ans;
    }
}
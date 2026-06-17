// class Solution {
//     public int reverseBits(int n) {
//         int reverse = 0;
//         for(int i=0; i<32; i++){
//             reverse <<= 1;
//             reverse = reverse | (n & 1);
//             n >>= 1;
//         }
//         return reverse;
//     }
// }

class Solution{
    public int reverseBits(int n){
        int rev = 0;
        for(int i=0; i<32; i++){
            rev = rev << 1;
            rev = rev | (n&1);
            n = n >> 1;
        }
        return rev;
    }
}
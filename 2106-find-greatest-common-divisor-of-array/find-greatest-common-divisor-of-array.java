// class Solution {
//     public int findGCD(int[] nums) {
//         int max = Integer.MIN_VALUE;
//         int min = Integer.MAX_VALUE;
//         for(int x  : nums){
//             max = Math.max(max, x);
//             min = Math.min(min, x);
//         }
//         return gcd(min, max);
//     }
//     private int gcd(int a, int b){
//         if(b==0) return a;
//         return gcd(b, a%b);
//     } 
// }


// piyush
class Solution{
    public int findGCD(int[] nums){
        int s = Integer.MAX_VALUE;
        int l = Integer.MIN_VALUE;
        for(int x : nums) {
            s = Math.min(x, s);
            l = Math.max(x, l);
        }
        return gcd(s, l);
    }
    private int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}
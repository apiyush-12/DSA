// class Solution {
//     public double myPow(double x, int n) {
//         if(n == 0) return 1;
//         long N = n;
//         if(N < 0){
//             x = 1/x;
//             N = -N;
//         }
//         double result = 1;
//         double currentPro = x;
//         while(N > 0){
//             if(N % 2 == 1){
//                 result *= currentPro;
//             }
//             currentPro *= currentPro;
//             N = N/2;
//         }
//         return result;
//     }
// }

class Solution{
    public double myPow(double x, int n){
        if(n == 0) return 1;
        long N = n;
        if(N < 0){
            x = 1/x;
            N = -N;
        }
        double result = 1;
        double currPro = x;
        while(N > 0){
            if(N % 2 == 1){
                result *= currPro;
            }
            currPro *= currPro;
            N /= 2;
        }
        return result;
    }
}
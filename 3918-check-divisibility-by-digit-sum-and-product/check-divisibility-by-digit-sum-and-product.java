// class Solution {
//     public boolean checkDivisibility(int n) {
//         int original = n;
//         int sum = 0;
//         int product = 1;
//         while(n != 0){
//             int lastD = n % 10;
//             sum += lastD;
//             product *= lastD;
//             n = n / 10;
//         }
//         int c = sum + product;
//         return (original % c) == 0;
//     }
// }

class Solution{
    public boolean checkDivisibility(int n){
        int original = n;
        int sum = 0;
        int pro = 1;
        while(n != 0){
            int lstD = n % 10;
            sum += lstD;
            pro *= lstD;
            n = n / 10;
        }
        int res = 0;
        res = sum + pro;
        return (original % res) == 0;
    }
}
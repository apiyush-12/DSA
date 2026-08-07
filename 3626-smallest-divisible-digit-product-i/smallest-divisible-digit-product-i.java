// class Solution {
//     private int pro(int n) {
//         int p = 1;
//         while (n != 0) {
//             p = p * (n % 10);
//             n = n / 10;
//         }
//         return p;
//     }

//     public int smallestNumber(int n, int t) {
//         while (pro(n) % t != 0)
//             n++;
//         return n;
//     }
// }


class Solution{
    private int pro(int n){
        int p = 1;
        while(n != 0){
            p = p*(n%10);
            n = n/10;
        }
        return p;
    }
    public int smallestNumber(int n, int t){
        while(pro(n) % t != 0) n++;
        return n;
    }
}
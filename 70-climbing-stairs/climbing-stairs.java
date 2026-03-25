// class Solution {
//     public int climbStairs(int n) {
//         if(n==0 || n==1) return 1;
//         int prev1=1, prev2=1, curr=0;
//         for(int i=2; i<=n; i++){
//             curr = prev1 + prev2;
//             prev1=prev2;
//             prev2=curr;
//         }
//         return curr;
//     }
// }









class Solution{
    public int climbStairs(int n){
    //     int i;
    //     int prev1 = i-1;
    //     int prev2 = i;
    //    int curr = 0;

    //    for(i = 1 ; i < n ; i++) {
      
    //     int curr = prev1 + prev2;

    //     prev1 = prev2;
    //     prev2
    //    }
    if(n==1) return 1;
    int prev = 1;
    int prev1 = 1;
    int curr=0;
    for(int i=2; i<=n; i++){
        curr = prev + prev1;
        prev = prev1;
        prev1 = curr;
    }
    return curr;
    }
}
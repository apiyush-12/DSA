// class Solution {
//     private final int MOD = 1000000007;
//     public int numOfSubarrays(int[] arr) {
//         int count = 0, ps = 0, oc = 0, ec = 1;
//         for(int num : arr){
//             ps += num;
//             if(ps % 2 == 0){
//                 count += oc;
//                 ec++;
//             }else{
//                 count += ec;
//                 oc++;
//             }
//             count %= MOD;
//         }
//         return count;
//     }
// }


class Solution{
    private final int MOD = 1000000007;
    public int numOfSubarrays(int[] arr){
        int count = 0, ps = 0, ec = 1, oc = 0;
        for(int num : arr){
            ps += num;
            if(ps % 2 == 0){
                count += oc;
                ec++;
            }else{
                count += ec;
                oc++;
            }
            count %= MOD;
        }
        return count;
    } 
}
// class Solution {
//     // time complexity=O(nlogn)
//     public int hIndex(int[] citations) {
//         Arrays.sort(citations);
//         for(int i=0; i<citations.length; i++){
//             if(citations[i]>=citations.length-i){
//                 return citations.length-i;
//             }
//         }
//         return 0;
//     }
// }

class Solution{
    public int hIndex(int[] citations){
        int n=citations.length;
        int[] arr=new int[n+1];
        for(int i=0; i<n; i++){
            int x=citations[i];
            if(x>=n){
                arr[n]++;
            }else{
                arr[x]++;
            }
        }
        int count=0;
        for(int j=n; j>=0; j--){
            count+=arr[j];
            if(count>=j){
                return j;
            }
        }
        return 0;
    }
}
// class Solution {
//     public int strStr(String haystack, String needle) {
//         int hayL=haystack.length();
//         int needleL=needle.length();
//         for(int i=0; i<=hayL-needleL; i++){
//             int j=0;
//             while(j<needleL && haystack.charAt(i+j)==needle.charAt(j)){
//                 j++;
//             }
//             if(j==needleL){
//                 return i;
//             }
//         }
//         return -1;
//     }
// }

class Solution{
    public int strStr(String haystack, String needle){
        if(haystack.contains(needle)){
            return haystack.indexOf(needle);
        }
        return -1;
    }
}
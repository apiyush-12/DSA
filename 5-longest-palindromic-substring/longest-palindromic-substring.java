// class Solution {
//     public String longestPalindrome(String s) {
//         if(s.length()<1 || s==null) return "";
//         int left=0, right=0;
//         for(int i=0; i<s.length(); i++){
//             int len1=checkPalindrome(s, i, i);
//             int len2=checkPalindrome(s, i, i+1);
//             int len=Math.max(len1, len2);
//             if(len > right-left){
//                 left=i-(len-1)/2;
//                 right=i+len/2;
//             } 
//         }
//         return s.substring(left, right+1);
//     }
//     public int checkPalindrome(String s, int L, int R){
//         while(L>=0 && R < s.length() && s.charAt(L)==s.charAt(R)){
//             L--;
//             R++;
//         }
//         return R-L-1;
//     }
// }


class Solution{
    public String longestPalindrome(String s){
        if(s==null || s.length() < 1) return "";
        int left=0, right=0;
        for(int i=0; i<s.length(); i++){
            int len1=Max(s, i, i);
            int len2=Max(s, i, i+1);
            int len=Math.max(len1, len2);
            if(len > right - left){
                left = i - (len-1)/2;
                right = i + len/2;
            }
        }
        return s.substring(left, right+1);
    }
    public int Max(String s, int L, int R){
        while(L >=0 && R < s.length() && s.charAt(L)==s.charAt(R)){
            L--;
            R++;
        }
        return R-L-1;
    }
}
// class Solution {
//     public int countSubstrings(String s) {
//         if(s==null || s.length()<1) return 0;
//         int ans=0;
//         for(int i=0; i<s.length(); i++){
//             ans += checkP(s, i, i);
//             ans += checkP(s, i, i+1);
//         }
//         return ans;
//     }
//     private int checkP(String s, int L, int R){
//         int count= 0;
//         while(L>=0 && R < s.length() && s.charAt(L)==s.charAt(R)){
//             L--;
//             R++;
//             count++;
//         }
//         return count;
//     }
// }


class Solution{
    public int countSubstrings(String s){
        if(s==null || s.length()==0) return 0;
        int len=0;
        for(int i=0; i<s.length(); i++){
            len +=Max(s, i, i);
            len +=Max(s, i, i+1);
        }
        return len;
    }
    private int Max(String s, int L, int R){
        int count=0;
        while(L>=0 && R<s.length() && s.charAt(L)==s.charAt(R)){
            L--;
            R++;
            count++;
        }
        return count;
    }
}
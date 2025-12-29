// class Solution {
//     public boolean isAnagram(String s, String t) {
//         if(s.length()!=t.length()){
//             return false;
//         }
//         int[] count=new int[26];
//         for(int i=0; i<s.length(); i++){
//             count[s.charAt(i)-'a']++;
//             count[t.charAt(i)-'a']--;
//         }
//         for(int C : count){
//             if(C!=0){
//                 return false;
//             }
//         }
//         return true;
//     }
// }


class Solution{
    public boolean isAnagram(String s, String t){
        int[] sA=new int[26];
        int[] tA=new int[26];
        for(char c : s.toCharArray()){
            sA[c-'a']++;
        }
        for(char c : t.toCharArray()){
            tA[c-'a']++;
        }
        return Arrays.equals(sA, tA);
    }
}
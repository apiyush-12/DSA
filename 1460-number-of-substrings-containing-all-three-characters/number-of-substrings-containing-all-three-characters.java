// class Solution {
//     public int numberOfSubstrings(String s) {
//         int[] last = {-1, -1, -1};
//         int count = 0;
//         for(int i=0; i<s.length(); i++){
//             last[s.charAt(i)-'a'] = i;
//             if(last[0] != -1 && last[1] != -1 && last[2] != -1){
//                 int minIdx = Math.min(last[0], Math.min(last[1], last[2]));
//                 count += (minIdx + 1);
//             }
//         }
//         return count;
//     }
// }


// piyush
// class Solution{
//     public int numberOfSubstrings(String s){
//         int[] last = {-1, -1, -1};
//         int count = 0;
//         for(int i=0; i<s.length(); i++){
//             last[s.charAt(i)-'a'] = i;
//             if(last[0] != -1 && last[1] != -1 && last[2] != -1){
//                 int minIdx = Math.min(last[0], Math.min(last[1], last[2]));
//                 count += (minIdx + 1);
//             }
//         }
//         return count;
//     }
// }


// piyush
// class Solution{
//     public int numberOfSubstrings(String s){
//         int[] last = {-1, -1, -1};
//         int count = 0;
//         for(int i=0; i<s.length(); i++){
//             last[s.charAt(i)-'a'] = i;
//             if(last[0] != -1 && last[1] != -1 && last[2] != -1){
//                 int minIdx = Math.min(last[0], Math.min(last[1], last[2]));
//                 count +=(minIdx + 1);
//             }
//         }
//         return count;
//     }
// }


class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int count=0;
        int left=0;  
        char freq[]=new char[3];
        for(int right=0; right<n; right++){
            freq[s.charAt(right)-'a']++;
            while(freq[0]>0 && freq[1]>0 && freq[2]>0){
                count += n-right;
                freq[s.charAt(left++)-'a']--;
            }
        }      
        return count;
    }
}
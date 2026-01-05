// class Solution {
//     public int characterReplacement(String s, int k) {
//         int[] occurence=new int[26];
//         int left=0, ans=0, maxOccurence=0;
//         for(int right=0; right<s.length(); right++){
//             maxOccurence=Math.max(maxOccurence, ++occurence[s.charAt(right)-'A']);
//             if(right-left+1 - maxOccurence > k){
//                 occurence[s.charAt(left)-'A']--;
//                 left++;
//             }
//             ans=Math.max(ans, right-left+1);
//         }
//         return ans;
//     }
// }

class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int ans = 0;
        for (int right = 0; right < s.length(); right++) {
            int idx = s.charAt(right) - 'A';
            freq[idx]++;
            maxFreq = Math.max(maxFreq, freq[idx]);
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
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

// class Solution {
//     public int characterReplacement(String s, int k) {
//         int[] freq = new int[26];
//         int left = 0;
//         int maxFreq = 0;
//         int ans = 0;
//         for (int right = 0; right < s.length(); right++) {
//             int idx = s.charAt(right) - 'A';
//             freq[idx]++;
//             maxFreq = Math.max(maxFreq, freq[idx]);
//             while ((right - left + 1) - maxFreq > k) {
//                 freq[s.charAt(left) - 'A']--;
//                 left++;
//             }
//             ans = Math.max(ans, right - left + 1);
//         }
//         return ans;
//     }
// }


//piyush
class Solution {
    public int characterReplacement(String s, int k) {

        char[] charArray = s.toCharArray();
        int l = 0;
        int max = 0;
        int maxFreq = 0;
        int[] array = new int[26];
        for(int r = 0; r < charArray.length; r++){
            array[charArray[r] - 'A']++;
            maxFreq = Math.max(maxFreq, array[charArray[r] - 'A']);
            while(r - l + 1 - maxFreq > k){
                array[charArray[l] - 'A']--;
                l++;
            }
            max = Math.max(max, r-l+1);
        }
        return max;
    }
}
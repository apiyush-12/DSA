// class Solution {
//     public int maxNumberOfBalloons(String text) {
//         int[] count = new int[26];
//         for(char c : text.toCharArray()){
//             count[c - 'a']++;
//         }
//         return Math.min(
//             Math.min(count['b'-'a'], count['a'-'a']),
//             Math.min(count['l'-'a']/2, Math.min(count['o'-'a']/2, count['n'-'a'])
//             )
//         );
//     }
// }

// piyush
// class Solution {
//     public int maxNumberOfBalloons(String text) {
//         int[] count = new int[26];
//         for(char c : text.toCharArray()){
//             count[c - 'a']++;
//         }
//         int b = count['b' - 'a'];
//         int a = count['a' - 'a'];
//         int l = count['l' - 'a'] / 2;
//         int o = count['o' - 'a'] / 2;
//         int n = count['n' - 'a'];
//         return Math.min(Math.min(Math.min(b, a), Math.min(l, o)), n);
//     }
// }

// class Solution{
//     public int maxNumberOfBalloons(String text){
//         int[] freq = new int[26];
//         for(char ch : text.toCharArray()) freq[ch - 'a']++;
//         int ans = Integer.MAX_VALUE;
//         ans = Math.min(ans, freq['b'-'a']);
//         ans = Math.min(ans, freq['a'-'a']);
//         ans = Math.min(ans, freq['l'-'a']/2);
//         ans = Math.min(ans, freq['o'-'a']/2);
//         ans = Math.min(ans, freq['n'-'a']);

//         return ans;
//     }
// }

class Solution{
    public int maxNumberOfBalloons(String text){
        int[] count = new int[26];
        for(char ch : text.toCharArray()) count[ch-'a']++;
        int ans = Integer.MAX_VALUE;
        ans = Math.min(ans, count['b'-'a']);
        ans = Math.min(ans, count['a'-'a']);
        ans = Math.min(ans, count['l'-'a']/2);
        ans = Math.min(ans, count['o'-'a']/2);
        ans = Math.min(ans, count['n'-'a']);

        return ans;
    }
}
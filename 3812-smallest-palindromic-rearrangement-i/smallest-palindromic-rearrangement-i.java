// class Solution {
//     public String smallestPalindrome(String s) {
//         int[] letterCount = new int[26];
//         for (char ch : s.toCharArray())
//             letterCount[ch - 'a']++;
//         StringBuilder leftSide = new StringBuilder();
//         StringBuilder middle = new StringBuilder();

//         for (int i = 0; i < 26; i++) {
//             int count = letterCount[i];
//             if (count % 2 != 0) {
//                 middle.append((char) (i + 'a'));
//             }
//             for (int j = 0; j < count / 2; j++)
//                 leftSide.append((char) (i + 'a'));
//         }
//         StringBuilder result = new StringBuilder();
//         result.append(leftSide);
//         result.append(middle);
//         result.append(leftSide.reverse());

//         return result.toString();
//     }
// }


class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        char[] ans = new char[n];
        int left = 0;
        int right = n - 1;

        for (int i = 0; i < 26; i++) {
            while (freq[i] >= 2) {
                char c = (char) ('a' + i);
                ans[left++] = c;
                ans[right--] = c;
                freq[i] -= 2;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] == 1) {
                ans[left] = (char) ('a' + i);
                break;
            }
        }

        return new String(ans);
    }
}
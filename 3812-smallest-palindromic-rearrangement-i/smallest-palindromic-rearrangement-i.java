class Solution {
    public String smallestPalindrome(String s) {
        int[] letterCount = new int[26];
        for (char ch : s.toCharArray())
            letterCount[ch - 'a']++;
        StringBuilder leftSide = new StringBuilder();
        StringBuilder middle = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            int count = letterCount[i];
            if (count % 2 != 0) {
                middle.append((char) (i + 'a'));
            }
            for (int j = 0; j < count / 2; j++)
                leftSide.append((char) (i + 'a'));
        }
        StringBuilder result = new StringBuilder();
        result.append(leftSide);
        result.append(middle);
        result.append(leftSide.reverse());

        return result.toString();
    }
}
// class Solution {
//     public int[] validSequence(String word1, String word2) {
//         int n = word1.length();
//         int m = word2.length();
//         int[] last = new int[m];
//         Arrays.fill(last, -1);
//         int word2Index = m-1;
//         for(int word1Index=n-1; word1Index>=0 && word2Index >=0; word1Index--){
//             if(word1.charAt(word1Index) == word2.charAt(word2Index)){
//                 last[word2Index] = word1Index;
//                 word2Index--;
//             }
//         }
//         int[] result = new int[m];
//         boolean usedChange = false;
//         word2Index = 0;
//         for(int word1Index = 0; word1Index < n && word2Index < m; word1Index++){
//             char currChar = word1.charAt(word1Index);
//             char reqChar = word2.charAt(word2Index);
//             boolean charMatch = currChar == reqChar;
//             boolean canUseChange = !usedChange && (word2Index == m-1 || word1Index < last[word2Index+1]);
//             if(charMatch || canUseChange){
//                 result[word2Index] = word1Index;
//                 if(!charMatch) usedChange = true;
//             word2Index++;
//             }
//         }
//         if(word2Index < m) return new int[0];
//         return result;
//     }
// }


class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[] suf = new int[m + 1];
        suf[m] = n;
        int p = n - 1;
        for (int j = m - 1; j >= 0; j--) {
            while (p >= 0 && word1.charAt(p) != word2.charAt(j)) {
                p--;
            }
            suf[j] = p--;
        }
        int[] res = new int[m];
        int j = 0;
        boolean used = false;
        for (int i = 0; i < n && j < m; i++) {
            if (word1.charAt(i) == word2.charAt(j)) {
                res[j++] = i;
            } else if (!used && i + 1 <= suf[j + 1]) {
                used = true;
                res[j++] = i;
            }
        }
        return j == m ? res : new int[0];
    }
}
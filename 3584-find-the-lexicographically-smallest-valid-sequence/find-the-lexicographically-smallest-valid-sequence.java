class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] last = new int[m];
        Arrays.fill(last, -1);
        int word2Index = m-1;
        for(int word1Index=n-1; word1Index>=0 && word2Index >=0; word1Index--){
            if(word1.charAt(word1Index) == word2.charAt(word2Index)){
                last[word2Index] = word1Index;
                word2Index--;
            }
        }
        int[] result = new int[m];
        boolean usedChange = false;
        word2Index = 0;
        for(int word1Index = 0; word1Index < n && word2Index < m; word1Index++){
            char currChar = word1.charAt(word1Index);
            char reqChar = word2.charAt(word2Index);
            boolean charMatch = currChar == reqChar;
            boolean canUseChange = !usedChange && (word2Index == m-1 || word1Index < last[word2Index+1]);
            if(charMatch || canUseChange){
                result[word2Index] = word1Index;
                if(!charMatch) usedChange = true;
            word2Index++;
            }
        }
        if(word2Index < m) return new int[0];
        return result;
    }
}
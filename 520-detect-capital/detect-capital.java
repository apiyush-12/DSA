class Solution {
    public boolean detectCapitalUse(String word) {
        int upperC = 0;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))){
                upperC++;
            }
        }
        return upperC == word.length() || upperC == 0 || upperC == 1 && Character.isUpperCase(word.charAt(0));
    }
}
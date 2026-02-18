class Solution {
    private String[] digitToLetters={"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> combinations=new ArrayList<>();
        if(digits==null || digits.length()==0){
            return combinations;
        }
        backTrack(combinations, digits, "", 0);
        return combinations;
    }
    private void backTrack(List<String> combinations, String digits, String currCombinations, int index){
        if(index==digits.length()){
            combinations.add(currCombinations);
            return;
        }
        String letters=digitToLetters[digits.charAt(index)-'0'];
        for(char letter : letters.toCharArray()){
            backTrack(combinations, digits, currCombinations+letter, index+1);
        }
    }
}
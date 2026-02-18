// class Solution {
//     private String[] digitToLetters={"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//     public List<String> letterCombinations(String digits) {
//         List<String> combinations=new ArrayList<>();
//         if(digits==null || digits.length()==0){
//             return combinations;
//         }
//         backTrack(combinations, digits, "", 0);
//         return combinations;
//     }
//     private void backTrack(List<String> combinations, String digits, String currCombinations, int index){
//         if(index==digits.length()){
//             combinations.add(currCombinations);
//             return;
//         }
//         String letters=digitToLetters[digits.charAt(index)-'0'];
//         for(char letter : letters.toCharArray()){
//             backTrack(combinations, digits, currCombinations+letter, index+1);
//         }
//     }
// }



class Solution{
    // piyush
      String[] digitMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits){
        List<String> res=new ArrayList<>();
        StringBuilder path=new StringBuilder();
        backTrack(digits, res, path, 0);
        return res;
    }
    private void backTrack(String digits, List<String> res, StringBuilder path, int i){
        if(i==digits.length()){
            String p=path.toString();
            res.add(p);
            return;
        }
        int digit=digits.charAt(i)-'0';
        String chars=digitMap[digit];
        for(char ch: chars.toCharArray()){
            path.append(ch);
            backTrack(digits, res, path, i+1);
            path.deleteCharAt(path.length()-1);
        }
    }
}
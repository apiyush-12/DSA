// class Solution {
//     public int minAddToMakeValid(String s) {
//         Stack<Character> stack = new Stack();
//         for (int i = 0; i < s.length(); i++) {
//             if (s.charAt(i) == '(') {
//                 stack.push(s.charAt(i));
//             } else if (!stack.isEmpty() && s.charAt(i) == ')' && stack.peek() == '(') {
//                 stack.pop();
//             } else {
//                 stack.push(s.charAt(i));
//             }
//         }
//         return stack.size();
//     }
// }

class Solution {
    public int minAddToMakeValid(String s) {
        int openCount = 0;
        int closeCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openCount++;
            } else {
                if (openCount > 0) {
                    openCount--;
                } else
                    closeCount++;
            }
        }
        return openCount + closeCount;
    }
}
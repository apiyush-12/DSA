class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            if(ch=='('|| ch=='{'||ch=='['){
                stack.push(ch);
            }else if(!stack.isEmpty() && ch==')' && stack.peek()=='('){
                stack.pop();
            }else if(!stack.isEmpty() && ch=='}' && stack.peek()=='{'){
                stack.pop();
            }else if(!stack.isEmpty() && ch==']' && stack.peek()=='['){
                stack.pop();
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }
}

// class Solution{
//     public boolean isValid(String s){
//         HashMap<Character, Character> mapB=new HashMap<>();
//         mapB.put(')','(');
//         mapB.put('}','{');
//         mapB.put(']','[');
//         Stack<Character> stack=new Stack<>();
//         for(int i=0; i<s.length(); i++){
//             char ch=s.charAt(i);
//             if(!mapB.containsKey(ch)){
//                 stack.push(ch);
//             }else{
//                 if(stack.isEmpty()){
//                     return false;
//                 }
//                 char topEle=stack.pop();
//                 if(topEle!=mapB.get(ch)){
//                     return false;
//                 }
//             }
//         }
//         return stack.isEmpty();
//     }
// }
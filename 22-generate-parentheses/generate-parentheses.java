// class Solution {
//     public List<String> generateParenthesis(int n) {
//         List <String> ans=new ArrayList();
//         backTrack(ans, new StringBuilder(), 0, 0, n);
//         return ans;
//     }
//     public void backTrack(List<String> ans, StringBuilder curr, int open, int close, int max){
//         if(curr.length()==max*2){
//             ans.add(curr.toString());
//             return;
//         }
//         if(open<max){
//             curr.append("(");
//             backTrack(ans, curr, open+1, close, max);
//             curr.deleteCharAt(curr.length()-1);
//         }
//         if(close<open){
//             curr.append(")");
//             backTrack(ans, curr, open, close+1, max);
//             curr.deleteCharAt(curr.length()-1);
//         }

//     }
// }

// piyush
// class Solution{
//     public List<String> generateParenthesis(int n){
//         List<String> ans=new ArrayList();
//         backTrack(ans, new StringBuilder(), 0, 0, n);
//         return ans;
//     }
//     public void backTrack(List<String> ans, StringBuilder curr, int open, int close, int max){
//         if(curr.length()==max*2){
//             ans.add(curr.toString());
//             return;
//         }
//         if(open<max){
//             curr.append("(");
//             backTrack(ans, curr, open+1, close, max);
//             curr.deleteCharAt(curr.length()-1);
//         }
//         if(close<open){
//             curr.append(")");
//             backTrack(ans, curr, open, close+1, max);
//             curr.deleteCharAt(curr.length()-1);
//         }
//     }
// }

class Solution{
    public List<String> generateParenthesis(int n){
        List<String> ans=new ArrayList();
        backTrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }
    public void backTrack(List<String> ans, StringBuilder curr, int open, int close, int max){
        if(curr.length()==max*2){
            ans.add(curr.toString());
            return;
        }
        if(open<max){
            curr.append("(");
            backTrack(ans, curr, open+1, close, max);
            curr.deleteCharAt(curr.length()-1);
        }
        if(close<open){
            curr.append(")");
            backTrack(ans, curr, open, close+1, max);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
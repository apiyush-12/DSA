// class Solution {
//     public boolean checkValidString(String s) {
//         int maxOpen = 0, minOpen = 0;
//         for(char c : s.toCharArray()){
//             if(c == '('){
//                 minOpen++;
//                 maxOpen++;
//             }else if(c == ')'){
//                 minOpen--;
//                 maxOpen--;
//             }else{    // we found star -> '*'
//                 minOpen--;
//                 maxOpen++;
//             }

//             if(maxOpen < 0){
//                 return false;
//             }
//             minOpen = Math.max(minOpen, 0);
//         }
//         return minOpen == 0;
//     }
// }

class Solution{
    public boolean checkValidString(String s){
        int minOpen = 0, maxOpen =0;
        for(int ch : s.toCharArray()){
            if(ch == '('){
                minOpen++;
                maxOpen++;
            }else if(ch == ')'){
                minOpen--;
                maxOpen--;
            }else{
                minOpen--;
                maxOpen++;
            }

            if(maxOpen < 0) return false;
            minOpen = Math.max(minOpen, 0);
        }
        return minOpen == 0;
    }
}
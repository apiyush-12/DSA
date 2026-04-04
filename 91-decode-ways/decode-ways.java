// class Solution {
//     public int numDecodings(String s) {
//         if(s.charAt(0)=='0') return 0;
//         int num1=1, num2=1;
//         for(int i=1; i<s.length(); i++){
//             int curr=0;
//             if(s.charAt(i) != '0') curr = num1;
//             int value=Integer.parseInt(s.substring(i-1, i+1));
//             if(value>= 10 && value<=26) curr = curr + num2;
//             num2=num1;
//             num1=curr;
//         }
//         return num1;
//     }
// }

class Solution{
    public int numDecodings(String s){
        if(s.charAt(0)=='0') return 0;
        int num1=1, num2=1;
        for(int i=1; i<s.length(); i++){
            int curr=0;
            if(s.charAt(i) !='0') curr=num1;
            int value=Integer.parseInt(s.substring(i-1, i+1));
            if(value>=10 && value<=26) curr = curr+num2;
            num2=num1;
            num1=curr;
        }
        return num1;
    }
}
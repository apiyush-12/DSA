// class Solution {
//     public char processStr(String s, long k) {
//         int n = s.length();
//         long[] len =  new long[n+1];
//         for(int i=0; i<n; i++){
//             char ch = s.charAt(i);
//             if(ch >='a' && ch <='z') len[i+1]=len[i]+1;
//             else if(ch == '*') len[i+1] = Math.max(0, len[i]-1);
//             else if(ch == '#') len[i+1] = len[i] * 2;
//             else len[i+1] = len[i];
//         }
//         if(k >= len[n]) return '.';

//         for(int i=n-1; i>=0; i--){
//             char ch = s.charAt(i);
//             if(ch >= 'a' && ch <= 'z'){
//                 if(k == len[i]) return ch;
//             }
//             else if(ch == '*'){
//                 // if(len[i] > 0){}
//             }
//             else if(ch == '#'){
//                 long half = len[i];
//                 if(k >= half) k -= half;
//             }
//             else{  // '%' symbol
//                 if(len[i] > 0) k = len[i]-1-k;
//             }
//         }
//         return '.';
//     }
// }


class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long len = 0;
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c == '*') {
                if(len > 0) len--;
            }else if(c == '#') len <<= 1;
            else if(c != '%') len++;
        }
        if(k >= len) return '.';

        for(int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if(c == '*') len++;
            else if(c == '%') k = len - 1 - k;
            else if(c == '#') {
                len >>= 1;
                if(k >= len) k -= len;
            }else if(k == --len) return c;
        }
        return '.';
    }
}
// class Solution {
//     public boolean sumGame(String num) {
//         int n = num.length();
//         int diff = 0;   //Sl - Sr
//         int qDiff = 0;   //qR-qL
//         for(int i=0; i<n/2; i++){
//             if(num.charAt(i) == '?') qDiff++;
//             else diff += num.charAt(i)-'0';
//         }
//         for(int i=n/2; i<n; i++){
//             if(num.charAt(i) == '?') qDiff--;
//             else diff -= num.charAt(i)-'0';
//         }

//         if(qDiff == 0) return diff !=0;

//         return diff * 2 != -9 * qDiff;
//     }
// }


class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int half = n / 2;
        int qDiff = 0;
        int sumDiff = 0;

        for (int i = 0; i < half; i++) {
            char c = num.charAt(i);
            if (c == '?') qDiff++;
            else sumDiff += c - '0';
        }

        for (int i = half; i < n; i++) {
            char c = num.charAt(i);
            if (c == '?') qDiff--;else {
                sumDiff -= c - '0';
            }
        }
        if (qDiff % 2 != 0) return true;
        return sumDiff + 9 * (qDiff / 2) != 0;
    }
}
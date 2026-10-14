// class Solution {
//     public String maxSumOfSquares(int num, int sum) {
//         if(sum > 9*num) return "";
//         StringBuilder result = new StringBuilder();
//         while(sum >= 9){
//             result.append('9');
//             sum -= 9;
//             num--;
//         }
//         if(num > 0 && sum > 0){
//             result.append((char)('0'+sum));
//             num--;
//         }
//         while(num > 0){
//             result.append('0');
//             num--;
//         }
//         return result.toString();
//     }
// }

class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > num * 9){ 
            return "";
        }
        int q = sum / 9, r = sum % 9;
        StringBuilder sb = new StringBuilder().repeat('9', q);
        if (r > 0){
            sb.append(r);
        }
        sb.repeat('0', num - sb.length());
        return sb.toString();
    }
}
// class Solution {
//     public boolean canAliceWin(int n) {
//         int take = 10;
//         boolean aliceTurn = true;
//         while(n >= take){
//             n -= take;
//             take--;
//             aliceTurn = !aliceTurn;
//         }
//         return !aliceTurn;
//     }
// }


class Solution{
    public boolean canAliceWin(int n){
        int take = 10;
        int move = 0;
        while(n >= take){
            n -= take;
            take--;
            move++;
        }
        return move % 2 == 1;
    }
}
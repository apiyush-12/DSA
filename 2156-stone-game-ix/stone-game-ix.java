// class Solution {
//     public boolean stoneGameIX(int[] stones) {
//         int[] cnt = new int[3];
//         for(int x : stones) cnt[x % 3]++;
//         int a = cnt[1];
//         int b = cnt[2];
//         int c = cnt[0];
//         if(c % 2 == 0) return a > 0 && b > 0;
//         return Math.abs(a-b) > 2;
//     }
// }


// class Solution{
//     public boolean stoneGameIX(int[] stones){
//         int[] cnt = new int[3];
//         for(int x : stones) cnt[x % 3]++;
//         if(cnt[0] % 2 == 0) return cnt[1] > 0 && cnt[2] > 0;
//         return Math.abs(cnt[1]-cnt[2]) > 2;
//     }
// }


class Solution{
    public boolean stoneGameIX(int[] stones){
        int[] cnt = new int[3];
        for(int x : stones) cnt[x % 3]++;
        if(cnt[0] % 2 == 0) return cnt[1] > 0 && cnt[2] > 0;
        return Math.abs(cnt[1]-cnt[2]) > 2;
    }
}
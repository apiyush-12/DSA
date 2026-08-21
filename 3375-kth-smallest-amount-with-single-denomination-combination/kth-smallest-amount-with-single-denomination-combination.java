// class Solution {
//     long gcd(long a , long b){
//         while(b != 0){
//             long temp = a % b;
//             a = b;
//             b = temp;
//         }
//         return a;
//     }
//     long lcm(long a, long b){
//         return a / gcd(a,b) * b;
//     }
//     long count(long x, int[] coins){
//         long ans = 0;
//         int n = coins.length;
//         for(int mask = 1; mask < (1<<n); mask++){
//             long multiple = 1;
//             int bits = 0;
//             for(int i=0; i<n; i++){
//                 if((mask & (1 << i)) != 0){
//                     bits++;
//                     multiple = lcm(multiple, coins[i]);
//                     if(multiple > x) break;
//                 }
//             }
//             if(multiple > x) continue;
//             long value = x / multiple;
//             if(bits % 2 == 1) ans += value;
//             else ans -= value;
//         }
//         return ans;
//     }
//     public long findKthSmallest(int[] coins, int k) {
//         long low  = 1;
//         long high = (long) coins[0]*k;
//         for(int coin : coins) high = Math.min(high, (long) coin * k);
//         while(low < high){
//             long mid = low + (high - low) /2;
//             if(count(mid, coins) >= k){
//                 high = mid;
//             }else{
//                 low = mid + 1;
//             }
//         }
//         return low;
//     }
// }


class Solution {
    public long findKthSmallest(int[] coins, int k) {
        Arrays.sort(coins);
        int n = coins.length;
        int m = 1 << n;

        long l = k;
        long r = (long) coins[0] * k + 1;

        int[] bitCount = new int[m];
        long[] lcm = new long[m];

        for (int mask = 1; mask < m; mask++) {
            long curLcm = 1;
            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 1) {
                    long g = gcd(curLcm, coins[i]);
                    long tmp = curLcm / g;

                    if (tmp <= r / coins[i]) {
                        curLcm = tmp * coins[i];
                    } else {
                        curLcm = r + 1;
                        break;
                    }
                    bitCount[mask]++;
                }
            }
            lcm[mask] = curLcm;
        }

        while (l < r) {
            long x = l + (r - l) / 2;
            if (count(x, m, lcm, bitCount) >= k) {
                r = x;
            } else {
                l = x + 1;
            }
        }
        return l;
    }

    private long count(long x, int m, long[] lcm, int[] bitCount) {
        long res = 0;
        for (int mask = 1; mask < m; mask++) {
            if (lcm[mask] > x) continue;

            if ((bitCount[mask] & 1) == 1) {
                res += x / lcm[mask];
            } else {
                res -= x / lcm[mask];
            }
        }
        return res;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
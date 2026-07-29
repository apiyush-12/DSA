// class Solution {
//     long[] fact;
//     static long maxK = 1000001;

//     public String smallestPalindrome(String s, int k) {
//         int[] freq = new int[26];
//         for (char ch : s.toCharArray())
//             freq[ch - 'a']++;

//         String mid = "";
//         for (int i = 0; i < 26; i++) {
//             if (freq[i] % 2 != 0) {
//                 mid = String.valueOf((char) (i + 'a'));
//                 break;
//             }
//         }
//         int[] half = new int[26];
//         int len = 0;
//         for (int i = 0; i < 26; i++) {
//             half[i] = freq[i] / 2;
//             len += half[i];
//         }
//         computeFactorials(len);
//         StringBuilder halfStr = new StringBuilder();
//         if (!buildKthPalindrome(half, k, halfStr, len))
//             return "";

//         StringBuilder rev = new StringBuilder(halfStr).reverse();
//         return halfStr.toString() + mid + rev.toString();
//     }

//     private boolean buildKthPalindrome(int[] freq, long k, StringBuilder sb, int len) {
//         if (len == 0)
//             return true;
//         for (int i = 0; i < 26; i++) {
//             if (freq[i] == 0)
//                 continue;
//             freq[i]--;
//             long perms = multinomial(freq);
//             if (k <= perms) {
//                 sb.append((char) (i + 'a'));
//                 return buildKthPalindrome(freq, k, sb, len - 1);
//             } else {
//                 k -= perms;
//                 freq[i]++;
//             }
//         }
//         return false;
//     }

//     private long multinomial(int[] counts) {
//         int tot = 0;
//         for (int x : counts)
//             tot += x;
//         long res = 1;
//         for (int i = 0; i < 26; i++) {
//             int cnt = counts[i];
//             res = res * binom(tot, cnt);
//             if (res >= maxK)
//                 return maxK;
//             tot -= cnt;
//         }
//         return res;
//     }

//     private long binom(int n, int k) {
//         if (k > n)
//             return 0;
//         if (k > n - k)
//             k = n - k;
//         long res = 1;
//         for (int i = 1; i <= k; i++) {
//             res = res * (n - i + 1) / i;
//             if (res >= maxK)
//                 return maxK;
//         }
//         return res;
//     }

//     private void computeFactorials(int n) {
//         fact = new long[n + 1];
//         fact[0] = 1;
//         for (int i = 1; i <= n; i++) {
//             fact[i] = fact[i - 1] * i;
//         }
//     }

// }


class Solution 
{
    private long comb(long n, long m, long k) 
    {
        long res = 1;
        m = Math.min(m, n - m);
        for (long i = 1; i <= m; i++) 
        {
            res = (res * (n - i + 1)) / i;
            if (res > k) return k + 1;
        }
        return res;
    }

    private long permutations(int rem, int[] bucket, long k) 
    {
        long ways = 1;
        for (int i = 0; i < 26; i++) 
        {
            if (bucket[i] == 0) continue;
            ways *= comb(rem, bucket[i], k);
            if (ways > k) break;
            rem -= bucket[i];
        }
        return ways;
    }

    public String smallestPalindrome(String s, long k) 
    {
        int partition = s.length() / 2;
        int[] bucket = new int[26];

        for (int i = 0; i < partition; i++) 
        {
            bucket[s.charAt(i) - 97] += 1;
        }

        StringBuilder left = new StringBuilder();
        long startIndex = 1;

        for (int pos = 0; pos < partition; pos++) 
        {
            for (int i = 0; i < 26; i++) 
            {
                if (bucket[i] == 0) continue;
                bucket[i] -= 1;

                long ways = permutations(partition - pos - 1, bucket, k);
                if (startIndex + ways > k) 
                {
                    left.append((char) (i + 97));
                    break;
                }

                bucket[i] += 1;
                startIndex += ways;
            }
        }

        if (left.length() < partition) return "";
        if (s.length() % 2 != 0) left.append(s.charAt(partition));

        for (int i = partition - 1; i >= 0; i--) 
        {
            left.append(left.charAt(i));
        }
        return left.toString();
    }
}
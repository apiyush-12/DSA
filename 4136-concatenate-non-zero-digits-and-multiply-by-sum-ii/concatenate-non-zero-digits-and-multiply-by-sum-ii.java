class Solution {
    int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        long[] preSum = new long[n + 1];
        long[] conVal = new long[n + 1];
        int[] count = new int[n + 1];
        long[] pow10 = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            int num = s.charAt(i-1)-'0';
            preSum[i] = (preSum[i - 1] + num) % MOD;
            if (num == 0) {
                conVal[i] = conVal[i - 1];
                count[i] = count[i - 1];
            } else {
                conVal[i] = (conVal[i - 1] * 10 + num) % MOD;
                count[i] = count[i - 1] + 1;
            }
        }
        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0], right = queries[i][1];
            long sum = (preSum[right + 1] - preSum[left] + MOD) % MOD;
            long leftPart = conVal[left], rightPart = conVal[right + 1];
            int diff = count[right + 1] - count[left];
            long power = pow10[diff];
            long range = (rightPart - (leftPart * power) % MOD + MOD) % MOD;
            long x = (range * sum) % MOD;
            ans[i] = (int) x;
        }
        return ans;
    }
}
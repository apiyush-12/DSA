class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] dp = new long[k];
        for(int num : nums){
            long[] next = new long[k];
            int value = num % k;
            next[value]++;
            for(int r=0; r<k; r++){
                int newRem = (r*value) % k;
                next[newRem] += dp[r];
            }
            for(int r=0; r<k; r++){
                result[r] += next[r];
            }
            dp = next;
        }
        return result;
    }
}
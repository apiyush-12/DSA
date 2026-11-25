class Solution {
    private static final long MOD1 = 1_000_000_007L;
    private static final long MOD2 = 1_000_000_009L;
    private static final long BASE = 911382323L;

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        long[] prefix1 = new long[n + 1];
        long[] prefix2 = new long[n + 1];
        long[] pow1 = new long[n + 1];
        long[] pow2 = new long[n + 1];

        pow1[0] = 1;
        pow2[0] = 1;

        for (int i = 0; i < n; i++) {
            prefix1[i + 1] = (prefix1[i] * BASE + nums[i]) % MOD1;
            prefix2[i + 1] = (prefix2[i] * BASE + nums[i]) % MOD2;

            pow1[i + 1] = (pow1[i] * BASE) % MOD1;
            pow2[i + 1] = (pow2[i] * BASE) % MOD2;
        }

        int low = 1, high = n;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (hasUniqueSubarray(nums, mid, prefix1, prefix2, pow1, pow2)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean hasUniqueSubarray(
            int[] nums,
            int len,
            long[] prefix1,
            long[] prefix2,
            long[] pow1,
            long[] pow2) {

        HashMap<Long, Integer> freq = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i + len <= n; i++) {
            int j = i + len;

            long hash1 = (prefix1[j] - prefix1[i] * pow1[len] % MOD1 + MOD1) % MOD1;
            long hash2 = (prefix2[j] - prefix2[i] * pow2[len] % MOD2 + MOD2) % MOD2;

            long key = (hash1 << 32) | hash2;

            freq.put(key, freq.getOrDefault(key, 0) + 1);
        }

        for (int count : freq.values()) {
            if (count == 1) {
                return true;
            }
        }

        return false;
    }
}
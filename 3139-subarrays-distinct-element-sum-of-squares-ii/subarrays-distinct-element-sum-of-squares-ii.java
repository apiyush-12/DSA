class Solution {
    static final int MOD = 1_000_000_007;
    int n;
    long[] sum, sq, lazy;

    void lazyAddition(int i, int l, int r, long val) {
        long len = r - l + 1;

        sq[i] += 2 * val * sum[i] + len * val * val;
        sum[i] += len * val;
    }
    void update(int start, int end, int i, int l, int r, long val) {
        if (lazy[i] != 0) {
            lazyAddition(i, l, r, lazy[i]);
            if (l != r) {
                lazy[2 * i] += lazy[i];
                lazy[2 * i + 1] += lazy[i];
            }
            lazy[i] = 0;
        }

        // Out of range
        if (l > end || r < start || l > r) {
            return;
        }

        // Completely within range
        if (l >= start && r <= end) {
            lazyAddition(i, l, r, val);
            if (l != r) {
                lazy[2 * i] += val;
                lazy[2 * i + 1] += val;
            }
            return;
        }
        int mid = l + (r - l) / 2;

        update(start, end, 2 * i, l, mid, val);
        update(start, end, 2 * i + 1, mid + 1, r, val);

        sum[i] = sum[2 * i] + sum[2 * i + 1];
        sq[i] = sq[2 * i] + sq[2 * i + 1];
    }

    public int sumCounts(int[] nums) {
        n = nums.length;

        sum = new long[4 * n];
        sq = new long[4 * n];
        lazy = new long[4 * n];
        int[] last = new int[100001];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int left = last[nums[i]];
            int right = i;
            update(left, right, 1, 0, n - 1, 1);
            ans = (ans + sq[1]) % MOD;
            last[nums[i]] = i + 1;
        }

        return (int) ans;
    }
}
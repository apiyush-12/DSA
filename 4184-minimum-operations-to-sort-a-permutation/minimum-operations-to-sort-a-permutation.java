class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        // Find the position of 0
        int start = 0;
        while (nums[start] != 0) {
            start++;
        }
        boolean asc = true;
        boolean desc = true;
        // Check circular order
        for (int i = 1; i < n; i++) {
            int value = nums[(start + i) % n];
            if (value != i) {
                asc = false;
            }
            if (value != n - i) {
                desc = false;
            }
            if (!asc && !desc) {
                return -1;
            }
        }
        // Calculate minimum operations
        if (asc) {
            return Math.min(start, n - start + 2);
        }
        return Math.min(n - start, start + 2);
    }
}
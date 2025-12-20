class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int max1 = robLinear(nums, 0, nums.length - 2);
        int max2 = robLinear(nums, 1, nums.length - 1);

        return Math.max(max1, max2); // MAXIMUM ROBBERY
    }

    private int robLinear(int[] nums, int start, int end) {
        int rob1 = 0, rob2 = 0;

        for (int i = start; i <= end; i++) {
            int curr = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = curr;
        }
        return rob2;
    }
}

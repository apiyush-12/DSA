class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int totalXOR = 0;
        for(int num : nums) totalXOR ^= num;
        boolean allZeroes = true;
        for(int num : nums){
            if(num != 0){
                allZeroes = false;
                break;
            }
        }
        if(allZeroes) return 0;
        if(totalXOR != 0) return n;
        return n-1;
    }
}
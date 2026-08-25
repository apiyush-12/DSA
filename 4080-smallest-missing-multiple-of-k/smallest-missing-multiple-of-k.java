class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int i=0; i<n; i++) set.add(nums[i]);
        int val = 1;
        while(set.contains(val * k)) val++;
        return val * k;
    }
}
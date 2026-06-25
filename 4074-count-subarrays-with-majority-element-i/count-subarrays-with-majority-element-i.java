class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length, count = 0;
        for(int i=0; i<n; i++){
            int tempCount = 0;
            for(int j=i; j<n; j++){
                if(nums[j] == target) tempCount++;
                if(tempCount * 2 > j-i+1) count++;
            }
        }
        return count;
    }
}
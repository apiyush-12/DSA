class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0, maxLen = 0, overCount = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while(right < n){
            int currNum = nums[right];
            map.put(currNum, map.getOrDefault(currNum, 0)+1);
            if(map.get(currNum) == k+1) overCount++;
            if(overCount > 0){
                int leftNum = nums[left];
                map.put(leftNum, map.get(leftNum)-1);
                if(map.get(leftNum) == k) overCount--;
                left++;
            }
            if(overCount == 0) maxLen = Math.max(maxLen, (right-left)+1);
            right++;
        }
        return maxLen;

    }
}
class Solution {
    public boolean canJump(int[] nums) {
        int finish = nums.length-1;
        for(int i=nums.length-2; i>=0; i--){
            if(i+nums[i] >= finish) finish = i;
        }
        if(finish == 0) return true;
        return false;
    }
}
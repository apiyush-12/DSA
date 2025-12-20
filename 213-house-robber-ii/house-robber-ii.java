class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int x=Max(nums, 0, nums.length-1);
        int y=Max(nums, 1, nums.length);
        return Math.max(x,y);
    }
    public int Max(int[] nums, int start, int end){
        int rob1=0, rob2=0, max=0;
        for(int i=start; i<end; i++){
            max=Math.max(rob1+nums[i], rob2);
            rob1=rob2;
            rob2=max;
        }
        return max;
    }
}
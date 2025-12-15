class Solution {
    public int jump(int[] nums) {
        int ans=0;
        int end=0;     //counting for jump (each window)
        int farthest=0;
        for(int i=0; i<nums.length-1; i++){
            farthest = Math.max(farthest, nums[i]+i);
            if(farthest>=nums.length-1){
                ans++;
                return ans;
            }
            if(i==end){
                ans++;
                end=farthest;
            }
        }
        return 0;
    }
}
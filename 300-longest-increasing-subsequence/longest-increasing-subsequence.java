class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] list=new int[nums.length];
        Arrays.fill(list, 1);
        int max=1;
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                    if(nums[i]>nums[j]){
                    list[i]=Math.max(list[i], 1+list[j]);
                    max=Math.max(max, list[i]);
                }
            }

        }
        return max;
    }
}
class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        if(nums[0]<nums[nums.length-1]){
            return nums[0];
        }
        int start=0;
        int end=nums.length-1;
        for(int i=0; i<nums.length; i++){
            int mid= start+(end-start)/2;
            if(mid!=0 && nums[mid]<nums[mid-1]){
                return nums[mid];
            }else if(mid!=nums.length-1 && nums[mid+1]<nums[mid]){
                return nums[mid+1];
            }else if(nums[start]>nums[end]){
                end--;
            }else{
                start++;
            }
        }
        return -1;
    }
}
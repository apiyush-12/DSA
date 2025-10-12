class Solution {
    // public int pivotIndex(int[] nums) {
    //     int rsum=0;
    //     for(int ele: nums){
    //         rsum+=ele;
    //     }
    //     int lsum=0;
    //     for(int i=0; i<nums.length; i++){
    //         rsum-=nums[i];
    //         if(rsum==lsum){
    //             return i;
    //         }
    //         lsum+=nums[i];
    //     }
    //     return -1;
    // }


    // piyush
    public int pivotIndex(int[] nums){
        int rSum=0;
        for(int ele: nums){
            rSum+=ele;
        }
        int lSum=0;
        for(int i=0; i<nums.length; i++){
            rSum-=nums[i];
            if(rSum==lSum){
                return i;
            }else{
                lSum+=nums[i];
            }
        }
        return -1;
    }
}
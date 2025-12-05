class Solution {
    // public int searchInsert(int[] nums, int target) {
    //     int mid;
    //     int left=0;
    //     int right=nums.length-1;
    //     while(left<=right){
    //         mid=left+(right-left)/2;
    //         if(nums[mid]==target){
    //             return mid;
    //         }
    //         else if(target<nums[mid]){
    //             right=mid-1;            
    //         }
    //         else{
    //             left=mid+1;
    //         }
    //     }
    //     return left;
    // }

    public int searchInsert(int[] nums, int target){
        int start=0;
        int end=nums.length-1;
        while(start<=end){
        for(int i=0; i<nums.length; i++){
            int mid=(start+end)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        }
        return start;
    }
}
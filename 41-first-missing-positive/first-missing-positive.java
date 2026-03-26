class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0, n = nums.length;
        while(i<n){
            if(nums[i]<=0){
                i++;
            }else{
                int curr = nums[i]-1;
                if(curr < n && nums[i]!=nums[curr]){
                    int temp = nums[curr];
                    nums[curr]=nums[i];
                    nums[i]=temp;
                }else{
                    i++;
                }
            }
        }
        for(int j=0; j<n; j++){
            if(nums[j]!=j+1){
                return j+1;
            }
        }
        return n+1;
    }
}
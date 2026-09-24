class Solution {
    public int smallestIndex(int[] nums) {
        int len = nums.length;
        for(int i=0; i<len; i++){
            int curr = nums[i];
            int digitSum = 0;
            while(curr != 0){
                digitSum += curr % 10;
                curr /= 10;
            }
            if(digitSum == i) return i;
        }
        return -1;
    }
}
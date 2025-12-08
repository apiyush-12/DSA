class Solution {
    // public int[] twoSum(int[] nums, int target) {
    //    Map<Integer, Integer> map=new HashMap<>();
    //    for(int i=0; i<nums.length; i++){
    //     int complement= target-nums[i];
    //     if(map.containsKey(complement)){
    //         return new int[] {map.get(complement), i};
    //     }
    //     else{
    //         map.put(nums[i], i);
    //     }
    // }
    // throw new IllegalArgumentException("No Match");
    // }

    // piyush
    public int[] twoSum(int[]nums, int target){
        for(int i=1; i<nums.length; i++){
            for(int j=0; i+j<nums.length; j++){
                if(nums[i+j]+nums[j]==target){
                    return new int[]{j, i+j};
                }
            }   
        }
        return new int[] {-1, -1};
    }
}
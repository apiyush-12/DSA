class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int i=0;
        while(i<n){
            int correct=nums[i]-1;
            if(nums[i] != nums[correct]){
                int temp = nums[i];
                nums[i]=nums[correct];
                nums[correct]=temp;
            }else{
                i++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(i=0; i<n; i++){
            if(nums[i] != i+1){
                result.add(i+1);
            }
        }
        return result;
    }
}
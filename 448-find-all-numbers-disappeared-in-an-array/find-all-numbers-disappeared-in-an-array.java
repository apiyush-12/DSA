// class Solution {
//     public List<Integer> findDisappearedNumbers(int[] nums) {
//         int n = nums.length;
//         int i=0;
//         while(i<n){
//             int correct=nums[i]-1;
//             if(nums[i] != nums[correct]){
//                 int temp = nums[i];
//                 nums[i]=nums[correct];
//                 nums[correct]=temp;
//             }else{
//                 i++;
//             }
//         }
//         List<Integer> result = new ArrayList<>();
//         for(i=0; i<n; i++){
//             if(nums[i] != i+1){
//                 result.add(i+1);
//             }
//         }
//         return result;
//     }
// }


class Solution{
    public List<Integer> findDisappearedNumbers(int[] nums){
        for(int i=0; i<nums.length; i++){
            int index= Math.abs(nums[i])-1;
            if(nums[index]>0){
                nums[index] =- nums[index];
            }
        }
        List<Integer> result=new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0){
                result.add(i+1);
            }
        }
        return result;
    } 
}
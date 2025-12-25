// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         // Time Complexity : O(n^2)
//         int[] list=new int[nums.length];
//         Arrays.fill(list, 1);
//         int max=1;
//         for(int i=1; i<nums.length; i++){
//             for(int j=0; j<i; j++){
//                     if(nums[i]>nums[j]){
//                     list[i]=Math.max(list[i], 1+list[j]);
//                     max=Math.max(max, list[i]);
//                 }
//             }

//         }
//         return max;
//     }
// }

class Solution{
    public int lengthOfLIS(int[] nums){
        ArrayList<Integer> sub=new ArrayList<>();
        sub.add(nums[0]);
        for(int i=1; i<nums.length; i++){
            if(nums[i]>sub.get(sub.size()-1)){
                sub.add(nums[i]);
            }
            else{
                int j=binarySearch(sub, nums[i]);
                sub.set(j, nums[i]);
            }
        }
        return sub.size();
    }
    private int binarySearch(ArrayList<Integer> sub, int num){
        int left=0;
        int right=sub.size()-1;
        while(left<right){
            int mid=(left+right)/2;
            if(sub.get(mid)==num){
                return mid;
            }
            if(sub.get(mid)<num){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }
}
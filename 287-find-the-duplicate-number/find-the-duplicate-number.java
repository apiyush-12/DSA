// class Solution {
//     public int findDuplicate(int[] nums) {
//         int slow=nums[0];
//         int fast=nums[nums[0]];
//         while(slow!=fast){
//             slow=nums[slow];
//             fast=nums[nums[fast]];
//         }
//         slow=0;
//         while(slow!=fast){
//             slow=nums[slow];
//             fast=nums[fast];
//         }
//         return slow;
//     }
// }

// class Solution{
//     public int findDuplicate(int[] nums){
//         int slow=nums[0];
//         int fast=nums[nums[0]];
//         while(slow!=fast){
//             slow=nums[slow];
//             fast=nums[nums[fast]];
//         }
//         slow=0;
//         while(slow!=fast){
//             slow=nums[slow];
//             fast=nums[fast];
//         }
//         return fast;
//     }
// }

class Solution{
    public int findDuplicate(int[] nums){
        int i=0;
        while(i<nums.length){
            if(nums[i]==-1){
                return i;
            }
            int next=nums[i];
            nums[i]=-1;
            i=next;
        }
        return -1;
    }
}
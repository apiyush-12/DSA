// class Solution {
//     public boolean containsDuplicate(int[] nums) {
//         HashSet<Integer> duplicate=new HashSet<>();
//         for(int num : nums){
//             if(duplicate.contains(num)){
//                 return true;
//             }
//             duplicate.add(num);
//         }
//         return false;
//     }
// }

// class Solution{
//     public boolean containsDuplicate(int[] nums){
//         HashSet <Integer> dup=new HashSet<>();
//         for(int num : nums){
//             if(!dup.add(num)){
//                 return true;
//             }
//         }
//         return false;
//     }
// }

// piyush
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num))
                return true;
        }
        return false;
    }
}
// class Solution {
//     public List<Integer> findMissingElements(int[] nums) {
//         int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
//         Set<Integer> seen = new HashSet<>();
//         for (int num : nums) {
//             seen.add(num);
//             min = Math.min(min, num);
//             max = Math.max(max, num);
//         }
//         List<Integer> missing = new ArrayList<>();
//         for (int i = min; i <= max; i++) {
//             if (!seen.contains(i))
//                 missing.add(i);
//         
//         return missing;
//     }
// }

class Solution{
    public List<Integer> findMissingElements(int[] nums){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> seen = new HashSet<>();

        for(int num : nums){
            seen.add(num);
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=min; i<=max; i++){
            if(!seen.contains(i)) ans.add(i);
        }
        return ans;
    }
}
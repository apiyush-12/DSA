// class Solution {
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         List<List<Integer>> res= new ArrayList<List<Integer>>();
//         List<Integer> combination=new ArrayList<>();
//         backTrack(target, res, combination, 0, candidates);
//         return res;
//     }
//     public void backTrack(int target, List<List<Integer>> res, List<Integer> combination, int start, int[] candidates){
//         if(target==0){
//             res.add(new ArrayList<Integer>(combination));
//         }
//         else if(target<0){
//             return;
//         }
//         for(int i=start; i<candidates.length; i++){
//             combination.add(candidates[i]);
//             backTrack(target-candidates[i], res, combination, i, candidates);
//             combination.remove(combination.size()-1);
//         } 
//     }
// }


class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        helper(candidates, 0, target, list);
        return result;
    }
    private void helper(int[] candidates, int idx, int target, List<Integer> list){
        if(idx == candidates.length){
            if(target == 0){
                result.add(new ArrayList<>(list));
            }
            return;
        }
        if(candidates[idx] <= target){
            list.add(candidates[idx]);
            helper(candidates, idx, target-candidates[idx], list);
            list.remove(list.size()-1);
        }
        helper(candidates, idx+1, target, list);
    }
}
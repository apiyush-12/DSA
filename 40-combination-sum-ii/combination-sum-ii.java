// class Solution {
//     public List<List<Integer>> combinationSum2(int[] candidates, int target){
//         List<List<Integer>> result=new ArrayList<>();
//         Arrays.sort(candidates);
//         backTrack(result, new ArrayList<>(), candidates, target, 0);
//         return result;
//     }
//     public void backTrack(List<List<Integer>> result, List<Integer> curr, int[] candidates, int target, int start){
//         if(target==0){
//             result.add(new ArrayList<>(curr));
//             return;
//         }   
//         for(int i=start; i<candidates.length; i++){
//             if(i>start && candidates[i]==candidates[i-1]){
//                 continue;
//             }
//             if(target-candidates[i]<0){
//                 break;
//             }
//             curr.add(candidates[i]);
//             backTrack(result, curr, candidates, target-candidates[i], i+1);
//             curr.remove(curr.size()-1);
//         }
//     }
// }


// piyush
// class Solution{
//     public List<List<Integer>> combinationSum2(int[] candidates, int target){
//         List<List<Integer>> result=new ArrayList<>();
//         Arrays.sort(candidates);
//         int n=candidates.length;
//         backTrack(result, new ArrayList<>(), candidates, target, 0, n);
//         return result;
//     }
//     public void backTrack(List<List<Integer>> result, List<Integer> curr, int[] candidates, int target, int start, int n){
//         if(target==0){
//             result.add(new ArrayList<>(curr));
//             return;
//         }
//         for(int i=start; i<n; i++){
//             if(i>start && candidates[i]==candidates[i-1]){
//                 continue;
//             }
//             if(target-candidates[i]<0){
//                 break;
//             }
//             curr.add(candidates[i]);
//             backTrack(result, curr, candidates, target-candidates[i], i+1, n);
//             curr.remove(curr.size()-1);
//         }
//     }
// }

class Solution{
    // piyush
    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
    public void backTrack(List<List<Integer>> result, List<Integer> curr, int[] candidates, int target, int start){
        if(target==0){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i=start; i<candidates.length; i++){
            if(i>start && candidates[i]==candidates[i-1]){
                continue;
            }
            if(target-candidates[i]<0){
                break;
            }
            curr.add(candidates[i]);
            backTrack(result, curr, candidates, target-candidates[i], i+1);
            curr.remove(curr.size()-1);
        }
    }
}

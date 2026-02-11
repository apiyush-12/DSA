class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        boolean[] used=new boolean[nums.length];
        backTrack(result, new ArrayList<>(), nums, used);
        return result;
    }
    public void backTrack(List<List<Integer>> result, List<Integer> curr, int[] nums, boolean[] used){
        if(curr.size()==nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(!used[i]){
                curr.add(nums[i]);
                used[i]=true;
                backTrack(result, curr, nums, used);
                used[i]=false;
                curr.remove(curr.size()-1);
            }
        }
    }
}
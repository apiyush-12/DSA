class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Set<Integer> seen = new HashSet<>();
        for(int num : nums){
            seen.add(num);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        List<Integer> missing =new ArrayList<>();
        for(int i = min; i<=max; i++){
            if(!seen.contains(i)) missing.add(i);
        }
        return missing;
    }
}
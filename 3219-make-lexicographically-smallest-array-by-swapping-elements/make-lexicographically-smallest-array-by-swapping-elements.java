class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[] numsSorted = new int[n];
        for(int i=0; i<n; i++) numsSorted[i] = nums[i];
        Arrays.sort(numsSorted);
        int currGroup = 0;
        HashMap<Integer, Integer> numToGroup = new HashMap<>();
        numToGroup.put(numsSorted[0], currGroup);

        HashMap<Integer, LinkedList<Integer>> groupToList = new HashMap<>();
        groupToList.put(currGroup, new LinkedList<Integer>(Arrays.asList(numsSorted[0])));
        for(int i=1; i<n; i++){
            if(Math.abs(numsSorted[i]-numsSorted[i-1]) > limit) currGroup++;
            numToGroup.put(numsSorted[i], currGroup);
            if(!groupToList.containsKey(currGroup)){
                groupToList.put(currGroup, new LinkedList<Integer>());
            }
            groupToList.get(currGroup).add(numsSorted[i]);
        }
        for(int i=0; i<n; i++){
            int num = nums[i];
            int group = numToGroup.get(num);
            nums[i] = groupToList.get(group).pop();
        }
        return nums;
    }
}
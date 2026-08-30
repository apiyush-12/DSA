// class Solution {
//     public int[] lexicographicallySmallestArray(int[] nums, int limit) {
//         int n = nums.length;
//         int[] numsSorted = new int[n];
//         for(int i=0; i<n; i++) numsSorted[i] = nums[i];
//         Arrays.sort(numsSorted);
//         int currGroup = 0;
//         HashMap<Integer, Integer> numToGroup = new HashMap<>();
//         numToGroup.put(numsSorted[0], currGroup);

//         HashMap<Integer, LinkedList<Integer>> groupToList = new HashMap<>();
//         groupToList.put(currGroup, new LinkedList<Integer>(Arrays.asList(numsSorted[0])));
//         for(int i=1; i<n; i++){
//             if(Math.abs(numsSorted[i]-numsSorted[i-1]) > limit) currGroup++;
//             numToGroup.put(numsSorted[i], currGroup);
//             if(!groupToList.containsKey(currGroup)){
//                 groupToList.put(currGroup, new LinkedList<Integer>());
//             }
//             groupToList.get(currGroup).add(numsSorted[i]);
//         }
//         for(int i=0; i<n; i++){
//             int num = nums[i];
//             int group = numToGroup.get(num);
//             nums[i] = groupToList.get(group).pop();
//         }
//         return nums;
//     }
// }


// class Solution {
//     public int[] lexicographicallySmallestArray(int[] nums, int limit) {
//         int[][] values = new int[nums.length][2];
//         for(int i=0;i<nums.length;i++){
//             values[i][0] = nums[i];
//             values[i][1] = i;
//         }
//         Arrays.sort(values,(a,b) -> a[0]-b[0]);

//         int start = 0;
//         while(start<nums.length){
//             int end = start;
//             while(end+1<nums.length && values[end+1][0] - values[end][0] <= limit){
//                 end++;
//             }
//             int  groupSize = end-start+1;
//             int[] indexArr = new int[groupSize];
//             for(int i=start;i<=end;i++){
//                 indexArr[i-start] = values[i][1];
//             }
//             Arrays.sort(indexArr);
//             for(int i=0;i<groupSize;i++){
//                 nums[indexArr[i]] = values[start+i][0];
//             }
//             start = end+1;
//         }
//         return nums;
//     }
// }


class Solution{
    public int[] lexicographicallySmallestArray(int[] nums, int limit){
        int[][] values = new int[nums.length][2];
        for(int i=0; i<nums.length; i++){
            values[i][0] = nums[i];
            values[i][1] = i;
        }
        Arrays.sort(values, (a,b) -> a[0]-b[0]);
        int start = 0;
        while(start < nums.length){
            int end = start;
            while(end+1 < nums.length && values[end+1][0]-values[end][0] <= limit){
                end++;
            }
            int groupSize = end - start + 1;
            int[] indexArr = new int[groupSize];
            for(int i= start; i<=end; i++){
                indexArr[i-start] = values[i][1];
            }
            Arrays.sort(indexArr);
            for(int i=0; i<groupSize; i++){
                nums[indexArr[i]] = values[start+i][0];
            }
            start = end + 1;
        }
        return nums;
    }
}
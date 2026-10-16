// class Solution {
//     public int sumCounts(List<Integer> nums) {
//         int n = nums.size();
//         int sum = 0;

//         for (int i = 0; i < n; i++) {
//             Set<Integer> set = new HashSet<>();

//             for (int j = i; j < n; j++) {
//                 set.add(nums.get(j));

//                 int count = set.size();
//                 sum += count * count;
//             }
//         }

//         return sum;
//     }
// }



// class Solution {
//     public int sumCounts(List<Integer> nums) {
//         int n = nums.size();
//         int answer = 0;

//         for (int i = 0; i < n; i++) {
//             boolean[] seen = new boolean[101];
//             int distinct = 0;

//             for (int j = i; j < n; j++) {
//                 int num = nums.get(j);

//                 if (!seen[num]) {
//                     seen[num] = true;
//                     distinct++;
//                 }

//                 answer += distinct * distinct;
//             }
//         }

//         return answer;
//     }
// }



class Solution{
    public int sumCounts(List<Integer> nums){
        int n = nums.size();
        int answer = 0;
        for(int i=0; i<n; i++){
            boolean[] seen = new boolean[101];
            int distinct = 0;
            for(int j=i; j<n; j++){
                int num = nums.get(j);
                if(!seen[num]){
                    seen[num] = true;
                    distinct++;
                }
                answer += distinct*distinct;
            }
        }
        return answer;
    }
}
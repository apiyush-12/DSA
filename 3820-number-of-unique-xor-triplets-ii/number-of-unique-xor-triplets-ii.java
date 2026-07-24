// class Solution {
//     public int uniqueXorTriplets(int[] nums) {
//         int maxVal = 0;
//         for(int num : nums){
//             maxVal = Math.max(maxVal, num);
//         }   
//         int xorLimit = 1;
//         while(xorLimit <= maxVal) xorLimit <<= 1;
//         boolean[] oneN = new boolean[xorLimit];
//         boolean[] twoN = new boolean[xorLimit];
//         boolean[] threeN = new boolean[xorLimit];

//         for(int num : nums) oneN[num] = true;

//         for(int num : nums){
//             for(int xorV = 0; xorV < xorLimit; xorV++){
//                 if(oneN[xorV]) twoN[xorV^num] = true;
//             }
//         }

//         for(int num : nums){
//             for(int xorV=0; xorV < xorLimit; xorV++){
//                 if(twoN[xorV]) threeN[xorV ^ num] = true;
//             }
//         }
//         int answer = 0;
//         for(boolean poss : threeN){
//             if(poss) answer++;
//         }
//         return answer;
//     }
// }


class Solution {
    public int uniqueXorTriplets(int[] nums) {
        boolean[] pairsPossible = new boolean[2048];
        boolean[] ans = new boolean[2048];

        int n = nums.length;
        for (int i=0;i<n;i++) {
            for (int j=i+1;j<n;j++) {
                pairsPossible[nums[i]^nums[j]] = true;
            }
        }

        // for triplets
        for (int e: nums) {
            ans[e] = true;
        }

        for (int i=0;i<2048;i++) {
            if (pairsPossible[i]) {
                for (int e: nums) {
                    ans[i^e] = true;
                }
            }
        }

        int ret = 0;
        for (boolean e: ans) {
            if (e) ret++;
        }
        return ret;
    }
}
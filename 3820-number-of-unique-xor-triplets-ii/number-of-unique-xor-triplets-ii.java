class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int maxVal = 0;
        for(int num : nums){
            maxVal = Math.max(maxVal, num);
        }   
        int xorLimit = 1;
        while(xorLimit <= maxVal) xorLimit <<= 1;
        boolean[] oneN = new boolean[xorLimit];
        boolean[] twoN = new boolean[xorLimit];
        boolean[] threeN = new boolean[xorLimit];

        for(int num : nums) oneN[num] = true;

        for(int num : nums){
            for(int xorV = 0; xorV < xorLimit; xorV++){
                if(oneN[xorV]) twoN[xorV^num] = true;
            }
        }

        for(int num : nums){
            for(int xorV=0; xorV < xorLimit; xorV++){
                if(twoN[xorV]) threeN[xorV ^ num] = true;
            }
        }
        int answer = 0;
        for(boolean poss : threeN){
            if(poss) answer++;
        }
        return answer;
    }
}
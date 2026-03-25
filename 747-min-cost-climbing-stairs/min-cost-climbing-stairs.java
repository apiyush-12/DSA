class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // if(cost.length==0) return cost[0];
        // if(cost.length==1) return Math.min(cost[0], cost[1]);
        int n=cost.length;
        int first=cost[0], sec=cost[1], currCost=0;
        for(int i=2; i<n; i++){
            currCost=Math.min(first, sec) + cost[i];
            first=sec;
            sec=currCost;
        }
        return Math.min(first, sec);
    }
}
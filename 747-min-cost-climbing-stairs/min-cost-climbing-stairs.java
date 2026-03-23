class Solution {
    public int minCostClimbingStairs(int[] cost) {
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
class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long cost = 0;
        long pair = Math.min(need1, need2);
        if((long) costBoth < cost1 + cost2){
            cost = pair*costBoth;
            need1 -= pair;
            need2 -= pair;
        }
        cost += (long) need1*Math.min(cost1, costBoth);
        cost += (long) need2*Math.min(cost2, costBoth);
        return cost;
    }
}
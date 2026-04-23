class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1)  return 0;
        int n =  prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        int[] rest = new int[n];

        buy[0] = -prices[0];
        sell[0] = 0;
        rest[0] = 0;

        for(int i=1; i<n; i++){
            buy[i] = Math.max(buy[i-1], rest[i-1]-prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1]+prices[i]);
            rest[i] = Math.max(rest[i-1], sell[i-1]);
        }
        return Math.max(sell[n-1], rest[n-1]);
    }
}
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int minPrice = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            minPrice = Math.min(minPrice, items[i][1]);
        }

        int[] weight = new int[n];
        for(int i=0; i<n; i++){
            weight[i] = 1;
            for(int j=0; j<n; j++){
                if(i != j && items[j][0] % items[i][0] == 0){
                    weight[i]++;
                }
            }
        }
        int[] dp = new int[budget + 1];
        for(int i=0; i<n; i++){
            int price = items[i][1];
            for(int j=budget; j>=price; j--){
                dp[j] = Math.max(dp[j], dp[j-price] + weight[i]);
            }
        }
        int ans = 0;
        for(int i=0; i<= budget; i++){
            int remainingBudget = budget - i;
            int extraItems = remainingBudget / minPrice;
            ans = Math.max(ans, dp[i] + extraItems);
        }
        return ans;
    }
}
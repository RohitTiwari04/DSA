class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
       int max_profit = 0;
       int best_buy = prices[0];

       for(int i = 0 ; i < n ; i++){
        if(prices[i] > best_buy){
            max_profit = Math.max(max_profit , prices[i] - best_buy);
        }
        best_buy = Math.min(best_buy , prices[i]);
       } 

       return max_profit;
    }
}
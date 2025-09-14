class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int minSofar = prices[0];
        int maxProfit = 0;

        for(int i = 0 ; i < n ; i++){
            minSofar = Math.min(minSofar , prices[i]);;
            int profit = prices[i] - minSofar;

            maxProfit = Math.max(maxProfit , profit);
        }
        return maxProfit;
    }
}
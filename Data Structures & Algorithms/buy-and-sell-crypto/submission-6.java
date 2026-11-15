class Solution {
    public int maxProfit(int[] prices) {
        int current_price = 0;
        int min_price = Integer.MAX_VALUE;
        int ans =0;
        for(int i=0; i < prices.length; i++){
            current_price = prices[i];
            
            if(current_price < min_price){
                min_price = current_price;
            }
            int profit = current_price - min_price;
            
            if(profit > ans){
                ans = profit;
            }
        }
        return ans;
    }
}

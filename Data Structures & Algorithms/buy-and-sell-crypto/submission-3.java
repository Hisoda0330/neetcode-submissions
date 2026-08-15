class Solution {
    public int maxProfit(int[] prices) {
        int day = 0;
        int maxprofit = 0;
        int min = Integer.MAX_VALUE;
        while(day < prices.length){
            min = Math.min(min, prices[day]);
            maxprofit = Math.max(maxprofit, prices[day] - min);
            day++;
        }
        return maxprofit;
    }
}

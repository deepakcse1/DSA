public class BestTimeToBuyAndSellStock {
  public static void main(String[] args) {
    
  }
  
  public int maxProfit(int[] prices) {
    int max = 0;
    for (int i = 0; i < prices.length; i++) {
      for (int j = i + 1; j < prices.length; j++) {
        if (prices[i] < prices[j]) {
          int profit = prices[j] - prices[i];
          if (max < profit) max = profit;
        }
      }
    }
    return max;
  }

  public int maxProfit_optimal(int[] prices) {
    int maxProfit = 0;
    int bestBuy = prices[0];
    for (int i = 1; i < prices.length; i++) {
      int profit = prices[i] - bestBuy;

      //give better result
      if(maxProfit <  profit) maxProfit =  profit;
      if(bestBuy > prices[i]) bestBuy = prices[i];

      // maxProfit = Math.max(maxProfit, profit);
      // bestBuy = Math.min(bestBuy, prices[i]);
    }
    return maxProfit;
  }

}

package program.corejava.dsa;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];//3,1
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);//1,3,6
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();
        int[] prices = {7, 8, 5, 3, 6, 4,9,1,3};
        System.out.println("Maximum Profit: " + solution.maxProfit(prices)); // Output: 6
    }
}

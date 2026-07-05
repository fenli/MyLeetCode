package p0122_best_time_to_buy_and_sell_stock_ii

class Solution {
    fun maxProfit(prices: IntArray): Int {
        if (prices.size == 0) return 0

        var totalProfit = 0
        var maxSessionProfit = 0
        var buyIndex = 0
        for (i in 1 until prices.size) {
            val profit = prices[i] - prices[buyIndex]
            if (profit > maxSessionProfit) {
                maxSessionProfit = profit

                if (prices[i] < prices[buyIndex]) buyIndex = i
            } else {
                totalProfit += maxSessionProfit
                maxSessionProfit = 0
                buyIndex = i
            }
        }

        totalProfit += maxSessionProfit
        
        return totalProfit
    }
}


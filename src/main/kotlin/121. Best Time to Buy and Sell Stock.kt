/**
 * Problem : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * Submission : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/1945596511
 */

class Solution121 {
    fun maxProfit(prices: IntArray): Int {
        if (prices.size <= 1) return 0
        var maxProfit = 0
        var buyIndex = 0
        for (i in 1 until prices.size) {
            val profit = prices[i] - prices[buyIndex]
            if (profit > maxProfit) {
                maxProfit = profit
            }

            if (prices[i] < prices[buyIndex]) {
                buyIndex = i
            }
        }

        return maxProfit
    }

    // Time Limit Exceeded
    // fun maxProfit(prices: IntArray): Int {
    //     if (prices.size <= 1) return 0
    //     var profit = 0
    //     for (i in 0 until prices.size - 1) {
    //         for (j in i+1 until prices.size) {
    //             val profitD = prices[j] - prices[i]
    //             if (profitD > profit) profit = profitD
    //         }
    //     }
    //     return profit
    // }
}

fun main() {
    val solution = Solution121()
    check(solution.maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)) == 5)
    check(solution.maxProfit(intArrayOf(7, 6, 4, 3, 1)) == 0)
}

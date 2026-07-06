import java.util.*

/**
 * Problem : https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/description/
 * Submission : https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/submissions/2057967423
 */

class Solution1475 {
    fun finalPrices(prices: IntArray): IntArray {
        if (prices.size == 1) return intArrayOf(prices[0])

        val stackOfIdx = Stack<Int>()
        val result = IntArray(prices.size)

        for (i in 0 until prices.size) {
            if (i == prices.size - 1) {
                result[i] = prices[i]
            } else if (prices[i + 1] <= prices[i]) {
                result[i] = prices[i] - prices[i + 1]
                while (!stackOfIdx.isEmpty()) {
                    val top = stackOfIdx.peek()
                    if (prices[i + 1] <= prices[top]) {
                        result[top] = prices[top] - prices[i + 1]
                        stackOfIdx.pop()
                    } else break
                }
            } else {
                stackOfIdx.push(i)
            }
        }

        // Fill empty array
        for (i in stackOfIdx) result[i] = prices[i]

        return result
    }
}

fun main() {
    val solution = Solution1475()
    check(solution.finalPrices(intArrayOf(8, 4, 6, 2, 3)).contentEquals(intArrayOf(4, 2, 4, 2, 3)))
    check(solution.finalPrices(intArrayOf(1, 2, 3, 4, 5)).contentEquals(intArrayOf(1, 2, 3, 4, 5)))
    check(solution.finalPrices(intArrayOf(10, 1, 1, 6)).contentEquals(intArrayOf(9, 0, 1, 6)))
}

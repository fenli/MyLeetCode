import java.util.*

/**
 * Problem : https://leetcode.com/problems/online-stock-span/description/
 * Submission : https://leetcode.com/problems/online-stock-span/submissions/2059429814
 */

class StockSpanner() {

    private val stack = Stack<Pair<Int, Int>>()

    fun next(price: Int): Int {
        var span = 1
        while (!stack.isEmpty() && stack.peek().first <= price) {
            span += stack.pop().second
        }
        stack.push(price to span)
        return span
    }
}

fun main() {
    val stockSpanner = StockSpanner()
    check(stockSpanner.next(100) == 1) // return 1
    check(stockSpanner.next(80) == 1) // return 1
    check(stockSpanner.next(60) == 1) // return 1
    check(stockSpanner.next(70) == 2) // return 2
    check(stockSpanner.next(60) == 1) // return 1
    check(stockSpanner.next(75) == 4) // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
    check(stockSpanner.next(85) == 6) // return 6
}

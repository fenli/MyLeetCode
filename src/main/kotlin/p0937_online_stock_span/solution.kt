package p0937_online_stock_span

class StockSpanner() {

    private val stack = Stack<Pair<Int, Int>>()

    fun next(price: Int): Int {
        var span = 1
        while(!stack.isEmpty() && stack.peek().first <= price) {
            span += stack.pop().second
        }
        stack.push(price to span)
        return span
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * var obj = StockSpanner()
 * var param_1 = obj.next(price)
 */

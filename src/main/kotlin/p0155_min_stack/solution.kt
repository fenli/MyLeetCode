package p0155_min_stack

class MinStack() {

    private val stack = Stack<Int>()
    private val minStack = Stack<Int>()

    fun push(`val`: Int) {
        stack.push(`val`)
        if (minStack.isEmpty() || `val` <= minStack.peek()) minStack.push(`val`)
    }

    fun pop() {
        val item = stack.pop()
        if (!minStack.isEmpty() && minStack.peek() == item) minStack.pop()
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return minStack.peek()
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */

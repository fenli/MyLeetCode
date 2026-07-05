package p0150_evaluate_reverse_polish_notation

class Solution {
    private val stack = Stack<Int>()

    fun evalRPN(tokens: Array<String>): Int {
        for (t in tokens) {
            stack.push(
                when(t) {
                    "+" -> stack.pop() + stack.pop()
                    "-" -> 0 - stack.pop() + stack.pop()
                    "*" -> stack.pop() * stack.pop()
                    "/" -> (1.0 / stack.pop() * stack.pop()).toInt()
                    else -> t.toInt()
                }
            )
        }

        return stack.pop()
    }
}

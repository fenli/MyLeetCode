import java.util.*

/**
 * Problem : https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 * Submission : https://leetcode.com/problems/evaluate-reverse-polish-notation/submissions/2056715725
 */

class Solution150 {
    private val stack = Stack<Int>()

    fun evalRPN(tokens: Array<String>): Int {
        for (t in tokens) {
            stack.push(
                when (t) {
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

fun main() {
    val solution = Solution150()
    check(solution.evalRPN(arrayOf("2", "1", "+", "3", "*")) == 9)
    check(solution.evalRPN(arrayOf("4", "13", "5", "/", "+")) == 6)
    check(solution.evalRPN(arrayOf("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+")) == 22)
}

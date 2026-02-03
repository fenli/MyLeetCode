import java.util.*

/**
 * Problem : https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 * Submission : https://leetcode.com/problems/evaluate-reverse-polish-notation/submissions/1906835273
 */

class Solution150 {
    private val stack = Stack<Int>()

    fun evalRPN(tokens: Array<String>): Int {
        for (t in tokens) {
            when (t) {
                "+" -> {
                    val top = stack.pop().toInt()
                    stack.push(stack.pop().toInt() + top)
                }

                "-" -> {
                    val top = stack.pop().toInt()
                    stack.push(stack.pop().toInt() - top)
                }

                "*" -> {
                    val top = stack.pop().toInt()
                    stack.push(stack.pop().toInt() * top)
                }

                "/" -> {
                    val top = stack.pop().toInt()
                    stack.push(stack.pop().toInt() / top)
                }

                else -> {
                    stack.push(t.toInt())
                }
            }
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

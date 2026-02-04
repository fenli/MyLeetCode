import java.util.*

/**
 * Problem : https://leetcode.com/problems/valid-parentheses/description/
 * Submission : https://leetcode.com/problems/valid-parentheses/submissions/1907403530
 */

class Solution20 {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        for (c in s) {
            if (stack.size == 0) {
                stack.push(c)
            } else if (c == ')') {
                if (stack.peek() != '(') return false
                else stack.pop()
            } else if (c == ']') {
                if (stack.peek() != '[') return false
                else stack.pop()
            } else if (c == '}') {
                if (stack.peek() != '{') return false
                else stack.pop()
            } else {
                stack.push(c)
            }
        }

        return stack.size == 0
    }
}

fun main() {
    val solution = Solution20()
    check(solution.isValid("()"))
    check(solution.isValid("()[]{}"))
    check(!solution.isValid("(]"))
    check(solution.isValid("([])"))
    check(!solution.isValid("([)]"))
}

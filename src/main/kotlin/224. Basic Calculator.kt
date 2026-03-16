import java.util.*

/**
 * Problem : https://leetcode.com/problems/basic-calculator/description/
 * Submission : https://leetcode.com/problems/basic-calculator/submissions/1949942894
 */

class Solution224 {

    fun calculate(s: String): Int {
        val rpn = arrayListOf<String>()
        val ops = Stack<Char>()
        var number = ""

        for (c in s) {
            when (c) {
                ' ' -> Unit
                '(' -> {
                    ops.push(c)
                }

                ')' -> {
                    if (!number.isEmpty()) {
                        rpn.add(number)
                        number = ""
                    }

                    do {
                        val last = ops.pop()
                        if (last != '(') rpn.add(last.toString())
                    } while (last != '(')
                }

                '+', '*', '/' -> {
                    if (!number.isEmpty()) {
                        rpn.add(number)
                        number = ""
                    }

                    if (!ops.isEmpty() && ops.peek() != '(') rpn.add(ops.pop().toString())
                    ops.push(c)
                }

                '-' -> {
                    var negative = false
                    if (!number.isEmpty()) {
                        rpn.add(number)
                        number = ""
                    } else if (
                        (ops.isEmpty() && rpn.lastOrNull()?.toIntOrNull() == null) ||
                        (!ops.isEmpty() && ops.peek() == '(' && (rpn.isEmpty() || rpn.lastOrNull()
                            ?.toIntOrNull() != null))
                    ) {
                        negative = true
                    }

                    if (!negative) {
                        if (!ops.isEmpty() && ops.peek() != '(') rpn.add(ops.pop().toString())
                        ops.push(c)
                    } else {
                        ops.push('_') // Negate operator
                    }
                }

                else -> {
                    number += c
                }
            }
        }

        if (!number.isEmpty()) rpn.add(number)
        while (!ops.empty()) {
            rpn.add(ops.pop().toString())
        }

        // println("RPN: " + rpn.toString())

        return evalRPN(rpn.toTypedArray())
    }

    fun evalRPN(tokens: Array<String>): Int {
        val stack = Stack<Long>()
        for (t in tokens) {
            when (t) {
                "+" -> {
                    val top = stack.pop()
                    stack.push(stack.pop() + top)
                }

                "-" -> {
                    val top = stack.pop()
                    stack.push(stack.pop() - top)
                }

                "*" -> {
                    val top = stack.pop()
                    stack.push(stack.pop() * top)
                }

                "/" -> {
                    val top = stack.pop()
                    stack.push(stack.pop() / top)
                }

                "_" -> { // Negate operator
                    val top = stack.pop()
                    stack.push(0 - top)
                }

                else -> {
                    stack.push(t.toLong())
                }
            }
        }

        return stack.pop().toInt()
    }
}

fun main() {
    val solution = Solution224()
    check(solution.calculate("1 + 1") == 2)
    check(solution.calculate(" 2-1 + 2 ") == 3)
    check(solution.calculate("(1+(4+5+2)-3)+(6+8)") == 23)
}

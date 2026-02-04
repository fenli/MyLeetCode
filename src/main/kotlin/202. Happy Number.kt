/**
 * Problem : https://leetcode.com/problems/happy-number/description/
 * Submission : https://leetcode.com/problems/happy-number/submissions/1907790863
 */

class Solution202 {
    fun isHappy(n: Int): Boolean {
        val history = hashSetOf<Int>()
        var number = n
        while (number != 1) {
            number = sumOfSquare(number)
            if (history.contains(number)) return false
            else history.add(number)
        }

        return true
    }

    fun sumOfSquare(number: Int): Int {
        if (number < 10) return number * number
        val digits = number.toString()
        var sums = 0
        for (c in digits) {
            val d = c.digitToInt()
            sums += d * d
        }
        return sums
    }
}

fun main() {
    val solution = Solution202()
    check(solution.isHappy(19))
    check(!solution.isHappy(2))
}

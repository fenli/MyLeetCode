/**
 * Problem : https://leetcode.com/problems/counting-bits/description/
 * Submission : https://leetcode.com/problems/counting-bits/submissions/1963929285
 */

import kotlin.math.floor
import kotlin.math.log2

class Solution338 {
    fun countBits(n: Int): IntArray {
        val result = IntArray(n + 1)
        result[0] = 0
        for (i in 1..n) {
            val noOfBit = floor(log2(i.toDouble()))
            val range = Math.pow(2.0, noOfBit).toInt()
            result[i] = 1 + result[i - range]
        }

        return result
    }
}

fun main() {
    val solution = Solution338()
    check(solution.countBits(2).contentEquals(intArrayOf(0, 1, 1)))
    check(solution.countBits(5).contentEquals(intArrayOf(0, 1, 1, 2, 1, 2)))
}

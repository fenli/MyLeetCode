/**
 * Problem : https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/description/
 * Submission : https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/submissions/1968323525
 */

class Solution1318 {
    fun minFlips(a: Int, b: Int, c: Int): Int {
        var count = 0
        var aa = a
        var bb = b
        var cc = c
        while (!(aa == 0 && bb == 0 && cc == 0)) {
            val lastA = aa and 1
            val lastB = bb and 1
            val lastC = cc and 1
            if (lastA or lastB != lastC) {
                if (lastA == 1 && lastB == 1 && lastC == 0) count += 2
                else count++
            }

            aa = aa shr 1
            bb = bb shr 1
            cc = cc shr 1
        }

        return count
    }
}

fun main() {
    val solution = Solution1318()
    check(solution.minFlips(2, 6, 5) == 3)
    check(solution.minFlips(4, 2, 7) == 1)
    check(solution.minFlips(1, 2, 3) == 0)
}

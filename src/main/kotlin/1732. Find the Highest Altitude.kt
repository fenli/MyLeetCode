/**
 * Problem : https://leetcode.com/problems/find-the-highest-altitude/description/
 * Submission : https://leetcode.com/problems/find-the-highest-altitude/submissions/1952168858
 */

class Solution1732 {
    fun largestAltitude(gain: IntArray): Int {
        var maxAlt = 0
        var currentAlt = 0
        for (n in gain) {
            currentAlt += n
            if (currentAlt > maxAlt) maxAlt = currentAlt
        }

        return maxAlt
    }
}

fun main() {
    val solution = Solution1732()
    check(solution.largestAltitude(intArrayOf(-5, 1, 5, 0, -7)) == 1)
    check(solution.largestAltitude(intArrayOf(-4, -3, -2, -1, 4, 3, 2)) == 0)
}

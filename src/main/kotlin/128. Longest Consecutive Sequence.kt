/**
 * Problem : https://leetcode.com/problems/longest-consecutive-sequence/description/
 * Submission : https://leetcode.com/problems/longest-consecutive-sequence/submissions/1908621293
 */

class Solution128 {
    fun longestConsecutive(nums: IntArray): Int {
        if (nums.size <= 1) return nums.size

        var result = 0
        val sets = nums.toSortedSet()
        var cons = 0
        var last = 0

        for (i in sets) {
            if (cons == 0 || i == last + 1) {
                cons++
            } else {
                cons = 1
            }

            last = i
            if (cons > result) result = cons
        }

        return result
    }
}

fun main() {
    val solution = Solution128()
    check(solution.longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)) == 4)
    check(solution.longestConsecutive(intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)) == 9)
    check(solution.longestConsecutive(intArrayOf(1, 0, 1, 2)) == 3)
}

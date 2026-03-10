/**
 * Problem : https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
 * Submission : https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/submissions/1943824405
 */

class Solution80 {
    fun removeDuplicates(nums: IntArray): Int {
        var p = 0
        var last = 0
        var twice = false
        for (i in 0 until nums.size) {
            val n = nums[i]
            if (i > 0) {
                if (n == last && !twice) {
                    nums[++p] = n
                    twice = true
                } else if (n > last) {
                    nums[++p] = n
                    twice = false
                }
            }

            last = n
        }

        return p + 1
    }
}

fun main() {
    val solution = Solution80()
    check(solution.removeDuplicates(intArrayOf(1, 1, 1, 2, 2, 3)) == 5)
    check(solution.removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3)) == 7)
}

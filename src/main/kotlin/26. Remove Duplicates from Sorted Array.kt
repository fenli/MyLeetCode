/**
 * Problem : https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 * Submission : https://leetcode.com/problems/remove-duplicates-from-sorted-array/submissions/1943812426
 */

class Solution26 {
    fun removeDuplicates(nums: IntArray): Int {
        var p = 0
        var last = 0
        for (i in 0 until nums.size) {
            val n = nums[i]
            if (i > 0 && n > last) {
                nums[++p] = n
            }
            last = n
        }

        return p + 1
    }
}

fun main() {
    val solution = Solution26()
    check(solution.removeDuplicates(intArrayOf(1, 1, 2)) == 2)
    check(solution.removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)) == 5)
}

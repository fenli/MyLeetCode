/**
 * Problem : https://leetcode.com/problems/single-number/description/
 * Submission : https://leetcode.com/problems/single-number/submissions/1968222944
 */

class Solution136 {
    fun singleNumber(nums: IntArray): Int {
        var result = nums[0]
        for (i in 1 until nums.size) {
            result = result xor nums[i]
        }

        return result
    }
}

fun main() {
    val solution = Solution136()
    check(solution.singleNumber(intArrayOf(2, 2, 1)) == 1)
    check(solution.singleNumber(intArrayOf(4, 1, 2, 1, 2)) == 4)
    check(solution.singleNumber(intArrayOf(1)) == 1)
}

/**
 * Problem : https://leetcode.com/problems/contains-duplicate-ii/description/
 * Submission : https://leetcode.com/problems/contains-duplicate-ii/submissions/1908040773
 */

class Solution219 {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val indexMap = hashMapOf<Int, Int>()

        for (i in 0 until nums.size) {
            val n = nums[i]
            val j = indexMap[n]
            if (j != null && Math.abs(i - j) <= k) return true
            indexMap[n] = i
        }

        return false
    }
}

fun main() {
    val solution = Solution219()
    check(solution.containsNearbyDuplicate(intArrayOf(1, 2, 3, 1), 3))
    check(solution.containsNearbyDuplicate(intArrayOf(1, 0, 1, 1), 1))
    check(!solution.containsNearbyDuplicate(intArrayOf(1, 2, 3, 1, 2, 3), 2))
}

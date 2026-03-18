/**
 * Problem : https://leetcode.com/problems/find-the-difference-of-two-arrays/description/
 * Submission : https://leetcode.com/problems/find-the-difference-of-two-arrays/submissions/1952209747
 */

class Solution2215 {
    fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
        val nums1set = hashSetOf<Int>()
        for (n in nums1) nums1set.add(n)

        val nums2set = hashSetOf<Int>()
        for (n in nums2) nums2set.add(n)

        return listOf(
            nums1set.filterNot { nums2set.contains(it) },
            nums2set.filterNot { nums1set.contains(it) }
        )
    }
}

fun main() {
    val solution = Solution2215()
    check(solution.findDifference(intArrayOf(1, 2, 3), intArrayOf(2, 4, 6)) == listOf(listOf(1, 3), listOf(4, 6)))
    check(solution.findDifference(intArrayOf(1, 2, 3, 3), intArrayOf(1, 1, 2, 2)) == listOf(listOf(3), listOf()))
}

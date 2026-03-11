/**
 * Problem : https://leetcode.com/problems/top-k-frequent-elements/description/
 * Submission : https://leetcode.com/problems/top-k-frequent-elements/submissions/1944980741
 */

class Solution347 {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = hashMapOf<Int, Int>()
        for (n in nums) {
            map[n] = (map[n] ?: 0) + 1
        }

        return map.entries
            .sortedBy { it.value }
            .takeLast(k)
            .map { it.key }
            .toIntArray()
    }
}

fun main() {
    val solution = Solution347()
    check(solution.topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), 2).contentEquals(intArrayOf(2, 1)))
    check(solution.topKFrequent(intArrayOf(1), 1).contentEquals(intArrayOf(1)))
    check(solution.topKFrequent(intArrayOf(1, 2, 1, 2, 1, 2, 3, 1, 3, 2), 2).contentEquals(intArrayOf(1, 2)))
}

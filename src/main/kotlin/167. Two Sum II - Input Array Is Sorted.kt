/**
 * Problem : https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 * Submission : https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/submissions/2057046701
 */

class Solution167 {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var firstIndex = 0
        var lastIndex = numbers.size - 1
        while (firstIndex < lastIndex) {
            val sum = numbers[firstIndex] + numbers[lastIndex]
            if (sum == target) return intArrayOf(firstIndex + 1, lastIndex + 1)
            else if (sum < target) firstIndex++
            else lastIndex--
        }

        return intArrayOf(0, 0)
    }
}

fun main() {
    val solution = Solution167()
    check(solution.twoSum(intArrayOf(2, 7, 11, 15), 9).contentEquals(intArrayOf(1, 2)))
    check(solution.twoSum(intArrayOf(2, 3, 4), 6).contentEquals(intArrayOf(1, 3)))
    check(solution.twoSum(intArrayOf(-1, 0), -1).contentEquals(intArrayOf(1, 2)))
}

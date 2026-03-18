import kotlin.math.min

/**
 * Problem : https://leetcode.com/problems/container-with-most-water/description/
 * Submission : https://leetcode.com/problems/container-with-most-water/submissions/1951868043
 */

class Solution11 {

    // O(n^2)
    fun maxArea2(height: IntArray): Int {
        var maxArea = 0
        for (i in 0 until height.size) {
            for (j in i + 1 until height.size) {
                val area = min(height[i], height[j]) * (j - i)
                if (area > maxArea) maxArea = area
            }
        }

        return maxArea
    }

    // O(n)
    fun maxArea(height: IntArray): Int {
        var maxArea = 0
        var leftP = 0
        var rightP = height.size - 1
        do {
            val area = min(height[leftP], height[rightP]) * (rightP - leftP)
            if (area > maxArea) maxArea = area

            if (height[leftP] < height[rightP]) leftP++
            else rightP--
        } while (rightP != leftP)
        return maxArea
    }
}

fun main() {
    val solution = Solution11()
    check(solution.maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)) == 49)
    check(solution.maxArea(intArrayOf(1, 1)) == 1)
}

package p0724_find_pivot_index

class Solution {
    fun pivotIndex(nums: IntArray): Int {
        if (nums.size == 1) return 0

        // RightSum
        val rightSumArr = IntArray(nums.size)
        var rightSum = 0
        for (i in (nums.size - 1) downTo 0) {
            rightSum += nums[i]
            rightSumArr[i] = rightSum
        }

        // LeftSum
        var leftSum = 0
        for (i in 0 until nums.size) {
            rightSum = if (i == nums.size - 1) 0 else rightSumArr[i + 1]
            if (leftSum == rightSum) return i
            leftSum += nums[i]
        }

        return -1
    }
}

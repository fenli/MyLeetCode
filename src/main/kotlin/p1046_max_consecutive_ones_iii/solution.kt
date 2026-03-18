package p1046_max_consecutive_ones_iii

class Solution {
    fun longestOnes(nums: IntArray, k: Int): Int {
        var maxOne = 0
        var zeros = 0
        var leftP = 0
        for (i in nums.indices) {
            if (nums[i] == 0) zeros++
            
            if (zeros <= k) {
                maxOne = max(maxOne, i + 1 - leftP)
            } else {
                while (zeros > k) if (nums[leftP++] == 0) zeros--
            }
        }

        return maxOne
    }
}

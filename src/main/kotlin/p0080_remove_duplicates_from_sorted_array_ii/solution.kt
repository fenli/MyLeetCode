package p0080_remove_duplicates_from_sorted_array_ii

class Solution {
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

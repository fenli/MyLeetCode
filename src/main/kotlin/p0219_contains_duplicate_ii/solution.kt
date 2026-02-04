package p0219_contains_duplicate_ii

class Solution {
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

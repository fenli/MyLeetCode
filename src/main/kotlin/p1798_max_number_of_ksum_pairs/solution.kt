package p1798_max_number_of_ksum_pairs

class Solution {
    fun maxOperations(nums: IntArray, k: Int): Int {
        val history = hashMapOf<Int, Int>()
        var ops = 0
        for (n in nums) {
            val diff = k - n
            if ((history[diff] ?: 0) > 0) {
                ops++
                history[diff] = (history[diff] ?: 0) - 1
            } else {
                history[n] = (history[n] ?: 0) + 1
            }
        }
        return ops
    }
}

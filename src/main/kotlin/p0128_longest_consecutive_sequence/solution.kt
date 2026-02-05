package p0128_longest_consecutive_sequence

class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        if (nums.size <= 1) return nums.size

        var result = 0
        val sets = nums.toSortedSet()
        var cons = 0
        var last = 0
        
        for (i in sets) {
            if (cons == 0 || i == last + 1) {
                cons++
            } else {
                cons = 1
            }

            last = i
            if (cons > result) result = cons
        }

        return result
    }
}

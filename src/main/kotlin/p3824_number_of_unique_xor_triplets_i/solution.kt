package p3824_number_of_unique_xor_triplets_i

class Solution {
    fun uniqueXorTriplets(nums: IntArray): Int {
        if (nums.size <= 2) return nums.size

        var mask = 0
        for (n in nums) mask = mask or n

        return mask + 1
    }
}

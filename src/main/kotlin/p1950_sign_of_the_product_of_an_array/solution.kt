package p1950_sign_of_the_product_of_an_array

class Solution {
    fun arraySign(nums: IntArray): Int {
        var negativeCount = 0
        for (n in nums) {
            if (n == 0) return 0
            if (n < 0) negativeCount++
        }

        return if (negativeCount % 2 == 0) 1 else -1
    }
}

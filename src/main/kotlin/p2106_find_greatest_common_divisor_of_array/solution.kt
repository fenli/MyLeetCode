package p2106_find_greatest_common_divisor_of_array

class Solution {
    fun findGCD(nums: IntArray): Int {
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE
        for (n in nums) {
            if (n < min) min = n
            if (n > max) max = n
        }

        return gcd(min, max)
    }

    private tailrec fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }
}

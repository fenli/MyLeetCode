package p0338_counting_bits

import kotlin.math.*

class Solution {
    fun countBits(n: Int): IntArray {
        val result = IntArray(n+1)
        result[0] = 0
        for (i in 1..n) {
            val noOfBit = floor(log2(i.toDouble()))
            val range = Math.pow(2.0, noOfBit).toInt()
            result[i] = 1 + result[i - range]
        }

        return result
    }
}

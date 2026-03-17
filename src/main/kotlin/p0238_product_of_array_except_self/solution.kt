package p0238_product_of_array_except_self

class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val size = nums.size
        val result = IntArray(size)
        val leftProduct = IntArray(size)
        val rightProduct = IntArray(size)

        var pL = 1
        var pR = 1
        for (i in 0 until size) {
            pL *= nums[i]
            leftProduct[i] = pL

            pR *= nums[size -1 -i]
            rightProduct[size -1 -i] = pR
        }

        for (i in 0 until size) {
            var p = 1
            if (i > 0) p *= leftProduct[i - 1]
            if (i < size - 1) p *= rightProduct[i + 1]
            result[i] = p
        }

        return result
    }
}

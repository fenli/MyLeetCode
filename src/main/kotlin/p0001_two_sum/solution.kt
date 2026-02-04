package p0001_two_sum

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val out = IntArray(2)
        val store = hashMapOf<Int, Int>()
        
        for (i in 0 until nums.size) {
            val diff = target-nums[i]
            if (store[diff] != null) {
                out[0] = store[diff]!!
                out[1] = i
                break
            } else store[nums[i]] = i
        }

        return out
    }
}

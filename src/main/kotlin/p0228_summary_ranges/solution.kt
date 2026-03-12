package p0228_summary_ranges

class Solution {
    fun summaryRanges(nums: IntArray): List<String> {
        if (nums.size == 0) return emptyList<String>()
        if (nums.size == 1) return listOf(nums[0].toString())

        val result = mutableListOf<String>()
        var startIndex = 0
        for (i in 1 until nums.size + 1) {
            if (i == nums.size || nums[i] != nums[i-1] + 1) {
                if (i == startIndex + 1) {
                    result.add(nums[startIndex].toString())
                } else {
                    result.add("${nums[startIndex].toString()}->${nums[i - 1].toString()}")
                }
                startIndex = i
            }
        }

        return result
    }
}

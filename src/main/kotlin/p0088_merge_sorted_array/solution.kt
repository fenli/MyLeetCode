package p0088_merge_sorted_array

class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        for (x in 0 until n) {
            val n2 = nums2[x]
            var carry: Int? = null
            for (i in 0..m+x) {
                if (nums1[i] == 0 && i >= m + x) {
                    if (carry != null) {
                        nums1[i] = carry
                    } else {
                        nums1[i] = n2
                    }
                    break
                } else if (n2 < nums1[i] && carry == null) {
                    carry = nums1[i]
                    nums1[i] = n2
                } else if (carry != null) {
                    val temp = nums1[i]
                    nums1[i] = carry
                    carry = temp
                }
            }
        }
    }
}

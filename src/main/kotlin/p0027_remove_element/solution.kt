package p0027_remove_element

class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var k = 0
        for (i in 0 until nums.size) {
            if (nums[i] != `val`) {
                if (k != i) {
                    val temp = nums[i] 
                    nums[i] = nums[k]
                    nums[k] = temp
                }
                k++
            }
        }

        return k
    }

    // Two Pointer
    // fun removeElement(nums: IntArray, `val`: Int): Int {
    //     var p2 = nums.size - 1
    //     while (p2 >=0 && nums[p2] == `val`) p2--

    //     for (i in 0 until nums.size) {
    //         if (i > p2) break

    //         val n = nums[i]
    //         if (n == `val`) {
    //             val temp = n
    //             nums[i] = nums[p2]
    //             nums[p2] = temp
    //             do { p2-- } while (p2 > i && nums[p2] == `val`)
    //         }
    //     }

    //     var k = 0
    //     for (n in nums) {
    //         if (n == `val`) break
    //         k++
    //     }

    //     return k
    // }
}

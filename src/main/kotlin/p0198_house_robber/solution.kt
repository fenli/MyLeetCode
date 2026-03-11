package p0198_house_robber

// Input =   [2,1,1,2]
// newRob = 0 2 1 3 4
// NoRob  = 0 0 2 2 3
class Solution {
    fun rob(nums: IntArray): Int {
        var rob = 0
        var noRob = 0
        for (n in nums) {
            val newRob = noRob + n
            noRob = max(noRob, rob)
            rob = newRob
        }

        return max(rob, noRob)
    }
}

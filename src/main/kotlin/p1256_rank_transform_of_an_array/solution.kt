package p1256_rank_transform_of_an_array

class Solution {
    fun arrayRankTransform(arr: IntArray): IntArray {
        if (arr.size == 0) return intArrayOf()

        val maps = mutableMapOf<Int, Int>()
        val ranks = IntArray(arr.size)

        var rank = 1
        for (n in arr.sorted()) {
            if (!maps.contains(n)) maps.put(n, rank++)
        }

        for (i in 0 until arr.size) {
            ranks[i] = maps.get(arr[i])!!
        }

        return ranks
    }
}

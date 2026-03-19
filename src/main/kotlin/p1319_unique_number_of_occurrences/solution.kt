package p1319_unique_number_of_occurrences

class Solution {
    fun uniqueOccurrences(arr: IntArray): Boolean {
        val counts = hashMapOf<Int, Int>()
        for (n in arr) {
            counts[n] = (counts[n] ?: 0) + 1
        }

        val sets = hashSetOf<Int>()
        for (item in counts) {
            if (!sets.add(item.value)) return false
        }

        return true
    }
}

package p1626_can_make_arithmetic_progression_from_sequence

class Solution {
    fun canMakeArithmeticProgression(arr: IntArray): Boolean {
        if (arr.size == 2) return true

        // Find max and min
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE
        for (n in arr) {
            if (n < min) min = n
            if (n > max) max = n
        }
        if (max == min) return true // all same number
        val diff = (max - min) / (arr.size - 1)
        if (diff == 0 && min != max) return false
        if (diff == 1 && max >= min + arr.size) return false

        val sets = mutableSetOf<Int>()
        for (n in arr) {
            if (sets.contains(n)) return false
            if ((n - min) % diff != 0) return false
            sets.add(n)
        }

        return true
    }
}

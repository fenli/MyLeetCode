package p4364_maximum_value_of_an_alternating_sequence

class Solution {
    fun maximumValue(n: Int, s: Int, m: Int): Long {
        if (n == 1) return s.toLong()
        val rSeq = n - 1
        val timesPlusM = (rSeq / 2) + rSeq % 2
        var timesMinusOne = rSeq - timesPlusM
        if (timesPlusM == timesMinusOne) timesMinusOne--
        
        return s - timesMinusOne + (m.toLong() * timesPlusM)
    }
}

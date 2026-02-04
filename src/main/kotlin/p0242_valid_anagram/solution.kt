package p0242_valid_anagram

class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val sums = hashMapOf<Char, Int>()
        for (i in 0 until s.length) {
            sums[s[i]] = (sums[s[i]] ?: 0) + 1
            sums[t[i]] = (sums[t[i]] ?: 0) - 1
        }
        
        return sums.all { it.value == 0 }
    }
}

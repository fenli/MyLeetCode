package p0028_find_the_index_of_the_first_occurrence_in_a_string

class Solution {

    fun strStr(haystack: String, needle: String): Int {
        if (haystack.length < needle.length) return -1

        var p2 = 0
        for (i in 0 until haystack.length) {
            if (haystack[i] == needle[p2]) p2++
            else {
                val n = p2
                p2 = 0
                for (j in 0 until n) {
                    for (k in 0 until j + 1) {
                        if (haystack[i-j+k] != needle[k]) break
                        if (k == j) p2 = k + 1
                    }
                }
            }

            if (p2 == needle.length) return i - p2 + 1
        }

        return -1
    }
}

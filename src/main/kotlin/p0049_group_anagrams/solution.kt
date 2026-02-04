package p0049_group_anagrams

class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val result = mutableListOf<MutableList<String>>()
        
        outer@ for (s in strs) {
            for (list in result) {
                val t = list.get(0)
                if (isAnagram(s, t)) {
                    list.add(s)
                    continue@outer
                }
            }
            result.add(mutableListOf(s))
        }

        return result
    }

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

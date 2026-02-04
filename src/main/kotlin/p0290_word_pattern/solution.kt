package p0290_word_pattern

class Solution {
    fun wordPattern(pattern: String, s: String): Boolean {
        val t = s.split(" ")
        if (t.size != pattern.length) return false

        val maps = hashMapOf<Char, String>()
        val hasUsed = hashMapOf<String, Boolean>()
        
        for (i in 0 until pattern.length) {
            val cs = pattern[i]
            val ct = t.get(i)
            if (maps[cs] == null) {
                if (hasUsed[ct] == true) return false
                
                maps[cs] = ct
                hasUsed[ct] = true
            } else if (maps[cs] != ct) return false
        }

        return true
    }
}

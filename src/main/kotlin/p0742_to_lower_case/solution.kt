package p0742_to_lower_case

class Solution {
    fun toLowerCase(s: String): String {
        val carr = s.toCharArray()
        for (i in 0 until carr.size) {
            val ascii = carr[i].code
            if (ascii >= 65 && ascii <= 90) carr[i] = (ascii + 32).toChar()
        }
        return String(carr)
    }
}

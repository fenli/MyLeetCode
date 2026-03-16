package p1146_greatest_common_divisor_of_strings

class Solution {
    fun gcdOfStrings(str1: String, str2: String): String {
        var divString = ""
        val shorter = if (str1.length <= str2.length) str1 else str2
        val longer = if (str1.length > str2.length) str1 else str2

        for (i in 0 until shorter.length) {
            if (shorter.length % (i + 1) == 0) {
                val repeatS = shorter.length / (i + 1)
                val repeatL = longer.length / (i + 1)

                val sub = shorter.substring(0, i+1)
                if (shorter == sub.repeat(repeatS) && longer == sub.repeat(repeatL)) {
                    divString = sub
                }
            }
        }

        return divString
    }
}

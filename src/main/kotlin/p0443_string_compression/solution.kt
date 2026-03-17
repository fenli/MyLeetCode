package p0443_string_compression

class Solution {
    fun compress(chars: CharArray): Int {
        if (chars.size == 1) return 1

        var pointer = 0
        var tempCount = 0
        var prevC: Char? = null

        for (c in chars) {
            if (c != prevC) {
                if (tempCount >= 1) {
                    chars[pointer++] = prevC!!

                    if (tempCount > 1) {
                        val countArr = tempCount.toString().toCharArray()
                        for (n in countArr) {
                            chars[pointer++] = n
                        }
                    }
                }

                tempCount = 1
                prevC = c
            } else {
                tempCount++
            }
        }

        chars[pointer++] = prevC!!
        if (tempCount > 1) {
            val countArr = tempCount.toString().toCharArray()
            for (n in countArr) {
                chars[pointer++] = n
            }
        }

        return pointer
    }
}

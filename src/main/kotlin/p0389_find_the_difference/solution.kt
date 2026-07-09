package p0389_find_the_difference

class Solution {
    fun findTheDifference(s: String, t: String): Char {
        var sumChar = 0
        for (c in t) sumChar += c.code
        for (c in s) sumChar -= c.code
        return sumChar.toChar()
    }
}

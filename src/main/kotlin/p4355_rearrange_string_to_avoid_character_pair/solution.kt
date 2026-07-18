package p4355_rearrange_string_to_avoid_character_pair

class Solution {
    fun rearrangeString(s: String, x: Char, y: Char): String {
        var countX = 0
        var countY = 0
        var others = ""
        for (c in s) {
            if (c == x) countX++
            else if (c == y) countY++
            else others += c
        }
        if (countX == 0 || countY == 0) return s

        return y.toString().repeat(countY) + others + x.toString().repeat(countX)
    }
}

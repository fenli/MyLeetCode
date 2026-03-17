package p0151_reverse_words_in_a_string

class Solution {
    fun reverseWords(s: String): String {
        var result = ""
        var temp = ""
        for (n in s) {
            if (n == ' ') {
                if (!temp.isEmpty()) result = temp + (if (result.isEmpty()) "" else " ") + result
                temp = ""
            } else {
                temp += n
            }
        }

        if (!temp.isEmpty()) result = temp + (if (result.isEmpty()) "" else " ") + result

        return result
    }
}

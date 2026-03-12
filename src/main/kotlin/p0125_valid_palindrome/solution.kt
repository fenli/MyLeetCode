package p0125_valid_palindrome

class Solution {
    fun isPalindrome(s: String): Boolean {
        val clean = buildString {
            for (c in s) {
                if (c.code >= 48 && c.code <= 57) append(c) // Digits
                else if (c.code >= 97 && c.code <= 122) append(c) // a-z
                else if (c.code >= 65 && c.code <= 90) append(c + 32) // A-Z
            }
        }
        

        if (clean.length <= 1) return true
        for (i in 0 until (clean.length / 2)) {
            if (clean[i] != clean[clean.length -1 - i]) return false
        }
        return true
    }
}

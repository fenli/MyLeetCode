/**
 * Problem : https://leetcode.com/problems/valid-palindrome/description/
 * Submission : https://leetcode.com/problems/valid-palindrome/submissions/1945613677
 */

class Solution125 {
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
            if (clean[i] != clean[clean.length - 1 - i]) return false
        }
        return true
    }
}

fun main() {
    val solution = Solution125()
    check(solution.isPalindrome("A man, a plan, a canal: Panama"))
    check(!solution.isPalindrome("race a car"))
    check(solution.isPalindrome(" "))
}

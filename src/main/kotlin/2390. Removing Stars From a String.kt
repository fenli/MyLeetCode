import java.util.*

/**
 * Problem : https://leetcode.com/problems/removing-stars-from-a-string/description/
 * Submission : https://leetcode.com/problems/removing-stars-from-a-string/submissions/1957805784
 */

class Solution2390 {
    fun removeStars(s: String): String {
        val chars = Stack<Char>()
        for (c in s) {
            if (c == '*') chars.pop()
            else chars.push(c)
        }
        return chars.joinToString("")
    }
}

fun main() {
    val solution = Solution2390()
    check(solution.removeStars("leet**cod*e") == "lecoe")
    check(solution.removeStars("erase*****") == "")
}

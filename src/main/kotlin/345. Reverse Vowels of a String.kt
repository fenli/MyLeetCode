/**
 * Problem : https://leetcode.com/problems/reverse-vowels-of-a-string/description/
 * Submission : https://leetcode.com/problems/reverse-vowels-of-a-string/submissions/1950780534
 */

class Solution345 {
    fun reverseVowels(s: String): String {
        val vowels = setOf('a', 'i', 'u', 'e', 'o', 'A', 'I', 'U', 'E', 'O')
        val arr = s.toCharArray()
        val found = arrayListOf<Int>()
        for (i in arr.indices) {
            if (vowels.contains(arr[i])) {
                found.add(i)
            }
        }

        for (j in 0 until found.size) {
            arr[found[j]] = s[found[found.size - 1 - j]]
        }

        return String(arr)
    }
}

fun main() {
    val solution = Solution345()
    check(solution.reverseVowels("IceCreAm") == "AceCreIm")
    check(solution.reverseVowels("leetcode") == "leotcede")
}

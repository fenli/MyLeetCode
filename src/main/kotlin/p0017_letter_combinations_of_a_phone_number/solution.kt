package p0017_letter_combinations_of_a_phone_number

class Solution {
    
    fun letterCombinations(digits: String): List<String> {
        val result = mutableListOf<String>()
        val mp = mapOf<Char, String>(
            '2' to "abc",
            '3' to "def",
            '4' to "ghi",
            '5' to "jkl",
            '6' to "mno",
            '7' to "pqrs",
            '8' to "tuv",
            '9' to "wxyz"
        )

        fun fn(l: MutableList<Char>, s: Int) {
            if (l.size == digits.length) {
                result.add(l.joinToString(""))
            } else for (c in mp[digits[s]]!!) {
                l.add(c)
                fn(l, s+1)
                l.removeLast()
            }
        }

        fn(mutableListOf(), 0)
        return result
    }
}

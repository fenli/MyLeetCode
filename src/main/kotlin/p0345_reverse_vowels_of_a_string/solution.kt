package p0345_reverse_vowels_of_a_string

class Solution {
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

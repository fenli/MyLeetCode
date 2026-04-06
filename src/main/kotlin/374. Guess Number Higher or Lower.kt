/**
 * Problem : https://leetcode.com/problems/guess-number-higher-or-lower/description/
 * Submission : https://leetcode.com/problems/guess-number-higher-or-lower/submissions/1970128479
 */

abstract class GuessGame(private val pick: Int) {
    abstract fun guessNumber(n: Int): Int

    fun guess(n: Int): Int {
        return if (n > pick) -1
        else if (n < pick) 1
        else 0
    }
}

class Solution374(pick: Int) : GuessGame(pick) {

    override fun guessNumber(n: Int): Int {
        if (guess(1) == 0) return 1
        if (guess(n) == 0) return n

        var top = n
        var bottom = 1
        var num = top
        var guess = -1
        while (guess != 0) {
            num = ((top.toLong() + bottom) / 2).toInt()
            guess = guess(num)
            if (guess == -1) {
                top = num
            } else if (guess == 1) {
                bottom = num
            }
        }

        return num
    }
}

fun main() {
    check(Solution374(pick = 6).guessNumber(10) == 6)
    check(Solution374(pick = 1).guessNumber(1) == 1)
    check(Solution374(pick = 1).guessNumber(2) == 1)
}

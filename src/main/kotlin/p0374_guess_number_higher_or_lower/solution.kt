package p0374_guess_number_higher_or_lower

/** 
 * The API guess is defined in the parent class.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * fun guess(num:Int):Int {}
 */

class Solution:GuessGame() {

    override fun guessNumber(n:Int):Int {
        if (guess(1) == 0) return 1
        if (guess(n) == 0) return n

        var top = n
        var bottom = 1
        var num = top
        var guess = -1
        while(guess != 0) {
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

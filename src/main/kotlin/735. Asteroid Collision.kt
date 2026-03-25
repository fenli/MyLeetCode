import java.util.*
import kotlin.math.abs

/**
 * Problem : https://leetcode.com/problems/asteroid-collision/description/
 * Submission : https://leetcode.com/problems/asteroid-collision/submissions/1958888985
 */

class Solution735 {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val s = Stack<Int>()
        for (a in asteroids) {
            if (s.isEmpty() || a > 0) s.push(a)
            else {
                do {
                    val top = s.peek()
                    if (top > 0) {
                        if (abs(top) < abs(a)) s.pop()
                        else if (abs(top) == abs(a)) {
                            s.pop()
                            break
                        } else break
                    } else {
                        s.push(a)
                        break
                    }

                    if (s.isEmpty()) {
                        if (abs(a) > abs(top)) s.push(a)
                        break
                    }
                } while (true)
            }
        }

        return s.toIntArray()
    }
}

fun main() {
    val solution = Solution735()
    check(solution.asteroidCollision(intArrayOf(5, 10, -5)).contentEquals(intArrayOf(5, 10)))
    check(solution.asteroidCollision(intArrayOf(8, -8)).contentEquals(intArrayOf()))
    check(solution.asteroidCollision(intArrayOf(10, 2, -5)).contentEquals(intArrayOf(10)))
    check(solution.asteroidCollision(intArrayOf(3, 5, -6, 2, -1, 4)).contentEquals(intArrayOf(-6, 2, 4)))
}

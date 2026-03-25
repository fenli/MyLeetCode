package p0735_asteroid_collision

class Solution {
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
                } while(true)
            }
        }

        return s.toIntArray()
    }
}

package p0657_robot_return_to_origin

class Solution {
    fun judgeCircle(moves: String): Boolean {
        var x = 0
        var y = 0
        for (c in moves) {
            when(c) {
                'R' -> x++
                'L' -> x--
                'U' -> y++
                'D' -> y--
            }
        }

        return x == 0 && y == 0
    }
}

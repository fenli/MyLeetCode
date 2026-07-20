package p1386_shift_2d_grid

class Solution {
    fun shiftGrid(grid: Array<IntArray>, k: Int): List<List<Int>> {
        val m = grid.size
        val n = grid[0].size
        val result = List(m) { row -> grid[row].toMutableList() }
        val kmod = k % (m * n)
        if (kmod > 0) for (i in 0 until m) {
            for (j in 0 until n) {
                val pos = (i * n + j + kmod) % (m*n)
                result[pos / n][pos % n] = grid[i][j]
            }
        }
        return result
    }
}

package p1677_matrix_diagonal_sum

class Solution {
    fun diagonalSum(mat: Array<IntArray>): Int {
        val n = mat.size
        if (n == 1) return mat[0][0]

        var sum = 0
        for (i in 0 until n) {
            // Primary
            sum += mat[i][i]

            // Secondary
            val j = n - 1 - i
            if (i != j) sum += mat[i][j]
        }

        return sum
    }
}

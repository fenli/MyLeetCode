package p0806_domino_and_tromino_tiling

class Solution {
    // f(n) = 2 * f(n-1) + f(n - 3)
    fun numTilings(n: Int): Int {
        if (n == 0) return 0
        val fn = IntArray(max(n, 2)+1)
        fn[0] = 1
        fn[1] = 1
        fn[2] = 2
        if (n <= 2) return fn[n]
        val mod = 1000000007 // 10^9 + 7
        for (i in 3..n) {
            val fnl: Long = (2L * fn[i-1]) + fn[i-3]
            val fni = (if (fnl > mod) fnl % mod else fnl).toInt()
            fn[i] = fni
        }

        return fn[n]
    }
}

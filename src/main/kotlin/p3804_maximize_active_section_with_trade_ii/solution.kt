package p3804_maximize_active_section_with_trade_ii

import java.util.regex.Pattern

class Solution_TLE {
    fun maxActiveSectionsAfterTrade(s: String, queries: Array<IntArray>): List<Int> {
        val result = mutableListOf<Int>()

        // Count all 1's in original string
        var allOnes = 0
        for (c in s) if (c == '1') allOnes++

        for ((li, ri) in queries) {
            // Find all max pair of 0's as prefix and suffix
            var prevChar: Char? = null
            var maxPairOfZeros = 0
            var lastCountZeros = -1
            var countZeros = 0
            for (i in li..ri) {
                val c = s[i]
                if (c == '0') countZeros++
                if ((c == '1' && prevChar == '0') || (c == '0' && i == ri)) {
                    if (lastCountZeros != -1) {
                        val currentPair = lastCountZeros + countZeros
                        if (currentPair > maxPairOfZeros) maxPairOfZeros = currentPair
                    }
                    
                    lastCountZeros = countZeros
                    countZeros = 0
                }

                prevChar = c
            }

            result.add(allOnes + maxPairOfZeros)
        }
        
        return result
    }
}

class Solution {

    private lateinit var zs: IntArray
    private lateinit var ze: IntArray
    private lateinit var V: IntArray
    private var nblocks = 0
    private val sparse = mutableListOf<IntArray>()

    fun maxActiveSectionsAfterTrade(s: String, queries: Array<IntArray>): List<Int> {
        val ones = s.count { it == '1' }

        // maximal zero-blocks (inclusive ends)
        val zsList = mutableListOf<Int>()
        val zeList = mutableListOf<Int>()

        val matcher = Pattern.compile("0+").matcher(s)
        while (matcher.find()) {
            zsList.add(matcher.start())
            zeList.add(matcher.end() - 1)
        }

        zs = zsList.toIntArray()
        ze = zeList.toIntArray()
        nblocks = zs.size

        // valley values
        V = IntArray(maxOf(0, nblocks - 1))
        for (i in V.indices) {
            V[i] =
                (ze[i] - zs[i] + 1) +
                (ze[i + 1] - zs[i + 1] + 1)
        }

        // sparse table for range maximum
        sparse.clear()
        sparse.add(V)

        var half = 1
        while (half * 2 <= V.size) {
            val prev = sparse.last()
            val next = IntArray(prev.size - half)
            for (i in next.indices) {
                next[i] = maxOf(prev[i], prev[i + half])
            }
            sparse.add(next)
            half *= 2
        }

        val ans = ArrayList<Int>(queries.size)
        for (q in queries) {
            ans.add(ones + gain(q[0], q[1]))
        }
        return ans
    }

    private fun rmq(lo: Int, hi: Int): Int {
        val t = 31 - Integer.numberOfLeadingZeros(hi - lo + 1)
        return maxOf(
            sparse[t][lo],
            sparse[t][hi - (1 shl t) + 1]
        )
    }

    private fun clip(j: Int, l: Int, r: Int): Int {
        return V[j] -
            maxOf(0, l - zs[j]) -
            maxOf(0, ze[j + 1] - r)
    }

    private fun gain(l: Int, r: Int): Int {
        if (nblocks < 2) return 0

        val ja = lowerBound(ze, l)
        val jb = upperBound(zs, r) - 2

        if (ja > jb) return 0

        return maxOf(
            maxOf(
                clip(ja, l, r),
                clip(jb, l, r)
            ),
            if (jb - ja >= 2) rmq(ja + 1, jb - 1) else 0
        )
    }

    private fun lowerBound(a: IntArray, x: Int): Int {
        var lo = 0
        var hi = a.size
        while (lo < hi) {
            val mid = (lo + hi) ushr 1
            if (a[mid] < x) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }
        return lo
    }

    private fun upperBound(a: IntArray, x: Int): Int {
        var lo = 0
        var hi = a.size
        while (lo < hi) {
            val mid = (lo + hi) ushr 1
            if (a[mid] <= x) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }
        return lo
    }
}

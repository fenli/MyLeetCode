package p3583_sorted_gcd_pair_queries

class Solution {
    fun gcdValues(nums: IntArray, queries: LongArray): IntArray {
        val mx = nums.max() + 1

        val cnts = IntArray(mx)
        val pairs = LongArray(mx)

        // Count occurrences
        for (num in nums) {
            cnts[num]++
        }

        // Calculate number of pairs with GCD exactly = i
        for (i in mx - 1 downTo 1) {
            var gs = 0L

            // Sum counts of multiples of i
            var j = i
            while (j < mx) {
                gs += cnts[j].toLong()
                j += i
            }

            var totalPairs = gs * (gs - 1) / 2

            // Subtract pairs already assigned to multiples of i
            j = i * 2
            while (j < mx) {
                totalPairs -= pairs[j]
                j += i
            }

            pairs[i] = totalPairs
        }

        // Prefix sum
        for (i in 1 until mx) {
            pairs[i] += pairs[i - 1]
        }

        // Answer queries using upperBound
        val result = IntArray(queries.size)
        for (k in queries.indices) {
            result[k] = upperBound(pairs, queries[k])
        }

        return result
    }

    private fun upperBound(arr: LongArray, target: Long): Int {
        var left = 0
        var right = arr.size

        while (left < right) {
            val mid = (left + right) ushr 1
            if (arr[mid] <= target) {
                left = mid + 1
            } else {
                right = mid
            }
        }

        return left
    }
}

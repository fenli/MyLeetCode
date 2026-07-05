/**
 * Problem : https://leetcode.com/problems/gas-station/description/
 * Submission : https://leetcode.com/problems/gas-station/submissions/2056650665
 */

class Solution134 {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        if (gas.size == 1) return if (gas[0] >= cost[0]) 0 else -1

        val trip = gas.size
        val lastIndex = (gas.size * 2) - 1
        var startIndex = -1
        var tank = 0
        for (i in 0 until lastIndex) {
            val n = i % gas.size

            if (startIndex == -1) {
                if (i > gas.size - 1) break

                tank = 0
                if (gas[n] >= cost[n]) {
                    startIndex = n
                    tank += gas[n] - cost[n]
                }
            } else {
                if (i - startIndex >= trip) break

                tank += gas[n] - cost[n]
                if (tank < 0) {
                    startIndex = -1
                }
            }
        }

        return startIndex
    }
}

fun main() {
    val solution = Solution134()
    check(solution.canCompleteCircuit(intArrayOf(1, 2, 3, 4, 5), intArrayOf(3, 4, 5, 1, 2)) == 3)
    check(solution.canCompleteCircuit(intArrayOf(2, 3, 4), intArrayOf(3, 4, 3)) == -1)
}

package p0134_gas_station

class Solution {
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

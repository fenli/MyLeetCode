package p0739_daily_temperatures

class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val stackOfIdx = Stack<Int>()
        val result = IntArray(temperatures.size)
        result[temperatures.size - 1] = 0

        for (i in 0 until temperatures.size - 1) {
            var j = i + 1
            if (temperatures[j] > temperatures[i]) {
                result[i] = 1
                while(!stackOfIdx.isEmpty()) {
                    val top = stackOfIdx.peek()
                    if (temperatures[j] > temperatures[top]) {
                        result[top] = j - top
                        stackOfIdx.pop()
                    } else break
                }
            } else {
                stackOfIdx.push(i)
            }
        }

        return result
    }
}

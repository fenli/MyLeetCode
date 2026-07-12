package p4357_number_of_elapsed_seconds_between_two_times

class Solution {
    fun secondsBetweenTimes(startTime: String, endTime: String): Int {
        val (startH, startM, startS) = startTime.split(":").map { it.toInt() }
        val (endH, endM, endS) = endTime.split(":").map { it.toInt() }

        var seconds = 0
        seconds += (endH - startH) * 3600
        seconds += (endM - startM) * 60
        seconds += endS - startS

        return seconds
    }
}

package p3805_maximize_active_section_with_trade_i

class Solution {
    fun maxActiveSectionsAfterTrade(s: String): Int {
        var prevChar: Char? = null
        var maxPairOfZeros = 0
        var countAllOnes = -2

        // Find all max pair of 0's as prefix and suffix
        var lastCountZeros = -1
        var countZeros = 0
        for (c in ("1" + s + "1")) {
            if (c == '0') {
                countZeros++
            } else {
                if (prevChar == '0') {
                    if (lastCountZeros != -1) {
                        val currentPair = lastCountZeros + countZeros
                        if (currentPair > maxPairOfZeros) maxPairOfZeros = currentPair
                    }
                    
                    lastCountZeros = countZeros
                    countZeros = 0
                }

                countAllOnes++
            }

            prevChar = c
        }
        
        return countAllOnes + maxPairOfZeros
    }
}

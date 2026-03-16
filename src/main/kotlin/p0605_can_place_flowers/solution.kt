package p0605_can_place_flowers

class Solution {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        if (n == 0) return true
        if (flowerbed.size == 1) return flowerbed[0] == 0
        var maxFlower = 0
        var emptyPot = 0
        var seenOne = false
        for(i in 0 until flowerbed.size) {
            if (flowerbed[i] == 1) {
                if (!seenOne && flowerbed[0] == 0) maxFlower += emptyPot / 2
                else maxFlower += (emptyPot - 1) / 2
                emptyPot = 0
                seenOne = true
            } else {
                emptyPot++
            }
        }
        maxFlower += if (seenOne) emptyPot / 2 else (emptyPot / 2) + (emptyPot % 2)

        return maxFlower >= n
    }
}

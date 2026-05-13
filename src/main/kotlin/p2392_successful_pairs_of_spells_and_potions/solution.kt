package p2392_successful_pairs_of_spells_and_potions

class Solution {
    fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
        val pairs = IntArray(spells.size)
        potions.sort()
        var pair = 0

        for (i in spells.indices) {
            val minPotion = Math.ceil(success / spells[i].toDouble()).toInt()
            pairs[i] = potions.size - findIndexOnSortedArr(minPotion, potions)
        }

        return pairs
    }

    fun findIndexOnSortedArr(target: Int, arr: IntArray): Int {
        if (arr[0] >= target) return 0
        if (arr[arr.size - 1] < target) return arr.size
        
        var low = 0
        var high = arr.size - 1
        var found = 0
        while (low <= high) {
            // Prevent overflow by using this formula instead of (low + high) / 2
            val mid = low + (high - low) / 2
            if (arr[mid] >= target) {
                // Search the left half
                found = mid
                high = mid - 1
            } else {
                // Search the right half
                low = mid + 1
            }
        }

        return found
    }
}

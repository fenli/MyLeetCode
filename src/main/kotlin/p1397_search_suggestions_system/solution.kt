package p1397_search_suggestions_system

class Trie() {

    class Node() {
        val children = hashMapOf<Char, Trie.Node>()
        val top3prefix = PriorityQueue<String>(compareByDescending { it })
        
        fun updateTopThreePrefix(prefix: String) {
            top3prefix.add(prefix)
            if (top3prefix.size > 3) top3prefix.poll()
        }
    }

    private val root = Trie.Node()

    fun insert(word: String) {
        var current = root
        for (c in word) {
            current = current.children.computeIfAbsent(c) { Trie.Node() }
            current.updateTopThreePrefix(word)
        }
    }

    fun getAllWordWithPrefix(prefix: String): List<String> {
        var current = root
        for (c in prefix) {
            current = current.children[c] ?: return listOf()
        }

        val temp = PriorityQueue(current.top3prefix)
        return generateSequence { temp.poll() }
            .toList()
            .reversed()
    }
}

class Solution {

    private val trie = Trie()
    
    fun suggestedProducts(products: Array<String>, searchWord: String): List<List<String>> {
        val result = mutableListOf<List<String>>()
        for (p in products) trie.insert(p)
        for (len in 1..searchWord.length) {
            result.add(trie.getAllWordWithPrefix(searchWord.substring(0, len)))
        }
        return result
    }
}

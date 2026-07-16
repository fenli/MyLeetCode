package p0208_implement_trie_prefix_tree

class Trie() {

    class Node() {
        val children = hashMapOf<Char, Trie.Node>()
        var isEndOfWord = false
    }

    private val root = Trie.Node()

    fun insert(word: String) {
        var current = root
        for (c in word) {
            current = current.children.getOrPut(c) { Trie.Node() }
        }
        current.isEndOfWord = true
    }

    fun search(word: String): Boolean {
        return getNodeWithPrefix(word)?.isEndOfWord ?: false
    }

    fun startsWith(prefix: String): Boolean {
        return getNodeWithPrefix(prefix) != null
    }

    private fun getNodeWithPrefix(prefix: String): Trie.Node? {
        var current = root
        for (c in prefix) {
            current = current.children[c] ?: return null
        }
        return current
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */

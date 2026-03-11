/**
 * Problem : https://leetcode.com/problems/same-tree/description/
 * Submission : https://leetcode.com/problems/same-tree/submissions/1944799680
 */

class Solution100 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true
        else if (p == null || q == null) return false
        else if (p?.`val` != q.`val`) return false
        return isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
    }
}

fun main() {
    val solution = Solution100()
}

/**
 * Problem : https://leetcode.com/problems/search-in-a-binary-search-tree/description/
 * Submission : https://leetcode.com/problems/search-in-a-binary-search-tree/submissions/1963747755
 */

class Solution700 {
    data class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)

    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) return null
        else if (root?.`val` == `val`) return root
        else if (root!!.`val` > `val`) return searchBST(root?.left, `val`)
        else return searchBST(root?.right, `val`)
    }
}

fun main() {
    fun List<Int?>.toTreeNode(index: Int = 0): Solution700.TreeNode? {
        if (index >= size) return null
        if (get(index) == null) return null

        return Solution700.TreeNode(get(index)!!, toTreeNode(index * 2 + 1), toTreeNode(index * 2 + 2))
    }

    val solution = Solution700()
    check(solution.searchBST(listOf(4, 2, 7, 1, 3).toTreeNode(), 2) == listOf(2, 1, 3).toTreeNode())
    check(solution.searchBST(listOf(4, 2, 7, 1, 3).toTreeNode(), 5) == null)
}

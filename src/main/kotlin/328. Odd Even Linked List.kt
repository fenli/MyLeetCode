/**
 * Problem : https://leetcode.com/problems/odd-even-linked-list/description/
 * Submission : https://leetcode.com/problems/odd-even-linked-list/submissions/1960796058
 */

class Solution328 {
    data class ListNode(var `val`: Int, var next: ListNode? = null)

    fun oddEvenList(head: ListNode?): ListNode? {
        var isOdd = true
        var oddNode: ListNode? = null
        var evenHead: ListNode? = null
        var evenNode: ListNode? = null
        var current = head
        while (current != null) {
            if (isOdd) {
                if (oddNode != null) oddNode?.next = current
                oddNode = current
            } else {
                if (evenHead == null) evenHead = current
                if (evenNode != null) evenNode?.next = current
                evenNode = current
            }

            isOdd = !isOdd
            current = current?.next
        }

        evenNode?.next = null
        oddNode?.next = evenHead

        return head
    }
}

fun main() {
    fun List<Int>.toListNode(): Solution328.ListNode? {
        if (isEmpty()) return null
        return Solution328.ListNode(first(), drop(1).toListNode())
    }

    val solution = Solution328()
    check(solution.oddEvenList(listOf(1, 2, 3, 4, 5).toListNode()) == listOf(1, 3, 5, 2, 4).toListNode())
    check(solution.oddEvenList(listOf(2, 1, 3, 5, 6, 4, 7).toListNode()) == listOf(2, 3, 6, 7, 1, 5, 4).toListNode())
}

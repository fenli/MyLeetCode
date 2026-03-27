package p2216_delete_the_middle_node_of_a_linked_list

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
 // 0 0 0 1 1 2 2
 // 1 2 3 4 5 6 7
 // 0 1 2 3 4 5 6
class Solution {
    fun deleteMiddle(head: ListNode?): ListNode? {
        if (head?.next == null) return null

        var mid: ListNode? = null
        var current = head
        var moveMid = false
        while(current != null) {
            current = current.next
            if (moveMid) mid = if (mid == null) head else mid?.next
            moveMid = !moveMid
        }
        mid?.next = mid?.next?.next

        return head
    }
}

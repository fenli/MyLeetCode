package p0328_odd_even_linked_list

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
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

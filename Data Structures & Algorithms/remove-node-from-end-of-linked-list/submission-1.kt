/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        head ?: return null
        var sz = 0
        var cur = head
        
        while(cur != null) {
            sz += 1
            cur = cur.next
        }

        cur = head
        var target = sz - n

        if (target == 0) {
            return head.next
        }

        var i = 0
        var prev: ListNode? = null

        while(cur != null) {
            i += 1

            if (target + 1 == i) {
                prev?.next = cur.next
                return head
            }

            prev = cur
            cur = cur.next
        }

        return head
    }

    // 1 2 3 4 5 6 7 8
}
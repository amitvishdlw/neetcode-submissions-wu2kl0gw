/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        val stk = ArrayDeque<ListNode>()
        
        var cur: ListNode? = head
        while(cur != null) {
            stk.addLast(cur)
            cur = cur.next
        }

        if (stk.isEmpty()) return null

        val rev = stk.removeLast()
        rev.next = if (stk.isEmpty) null else stk.last

        while (!stk.isEmpty()) {
            val top = stk.removeLast()
            top.next = if (stk.isEmpty) null else stk.last
        }
        return rev
    }
}

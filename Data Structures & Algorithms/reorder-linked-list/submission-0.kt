/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {
        head ?: return
        head?.next ?: return 
        head?.next?.next ?: return
        
        var cur = head
        val stk = ArrayDeque<ListNode>()
        
        while(cur != null) {
            stk.addLast(cur)
            cur = cur.next
        }

        cur = head
    
        while (cur != null && cur?.next != null) {
            var temp = cur?.next
            var curP = stk.removeLast()
            if (temp == curP || cur == curP) {
                curP?.next = null
                return
            }
            cur?.next = curP
            curP?.next = temp
            cur = temp
        }
    }
}

/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var i1 = list1
        var i2 = list2
        var res: ListNode = ListNode(-1)
        var cur: ListNode? = res

        while (i1 != null && i2 != null) {
            if (i1.`val` <= i2.`val`) {
                cur!!.next = i1
                i1 = i1.next
            } else {
                cur!!.next = i2
                i2 = i2.next
            }
            cur = cur!!.next
        }

        cur!!.next = i1 ?: i2

        return res.next
    }
}

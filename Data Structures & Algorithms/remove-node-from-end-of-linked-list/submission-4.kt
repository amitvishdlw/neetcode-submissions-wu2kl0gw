/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    private fun rec(cur: ListNode?, n: IntArray): ListNode? {
        cur ?: return null
        cur?.next = rec(cur?.next, n)
        n[0]--

        return if (n[0] == 0) {
            cur?.next
        } else {
            cur
        }
    }

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        return rec(head, intArrayOf(n))
    }
}
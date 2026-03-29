/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        var slow = head
        var fast = head

        while (slow!= null && fast != null) {
            slow = slow?.next
            fast = fast?.next?.next
            if (slow != null && fast != null && slow == fast) {
                return true
            }
        }

        return false
    }
}

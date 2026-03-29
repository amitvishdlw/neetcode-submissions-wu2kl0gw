/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        var dummy = ListNode(0)
        var cur: ListNode? = dummy
        
        while(true) {
            var minIdx = -1
            var minElem = Int.MAX_VALUE

            lists.forEachIndexed { idx, list ->
                if (list != null && list.`val` < minElem) {
                    minIdx = idx
                    minElem = list!!.`val`
                }
            }

            if (minIdx == -1) {
                cur?.next = null
                break
            }

            cur?.next = lists[minIdx]
            cur = cur?.next
            lists[minIdx] = lists[minIdx]?.next
        }

        return dummy.next
    }
}

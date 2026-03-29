/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        return isValidBST(root, Int.MIN_VALUE, Int.MAX_VALUE)
    }

    private fun isValidBST(cur: TreeNode?, minB: Int, maxB: Int): Boolean {
        cur ?: return true
        if (cur.`val` <= minB || cur.`val` >= maxB) return false
        if (!isValidBST(cur?.left, minB, cur.`val`)) return false
        if (!isValidBST(cur?.right, cur.`val`, maxB)) return false

        return true
    }
}

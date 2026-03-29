/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        root ?: return 0
        return rec(root, intArrayOf(k))
    }

    fun rec(root: TreeNode?, k: IntArray): Int {
        root ?: return -1
        val left = rec(root?.left, k)
        if (left != -1) return left
        k[0]--
        if (k[0] == 0) return root!!.`val`
        val right = rec(root?.right, k)
        if (right != -1) return right
        return -1
    }
}

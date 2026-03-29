/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        root ?: return 0
        val leftHeight = maxDepth(root.left)
        val rightHeight = maxDepth(root.right)

        return 1 + max(leftHeight, rightHeight)
    }
}

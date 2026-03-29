/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        root ?: return true
        if (!isValidBST(root?.left) {
            it < root.`val`
        }) {
            return false
        }

        if (!isValidBST(root?.right) {
            it > root.`val`
        }) {
            return false
        }

        return isValidBST(root?.left) && isValidBST(root?.right)
    }

    fun isValidBST(root: TreeNode?, valid: (Int) -> Boolean): Boolean  {
        root ?: return true
        if (!valid(root.`val`)) return false
        return isValidBST(root?.left, valid) && isValidBST(root?.right, valid)
    }
}

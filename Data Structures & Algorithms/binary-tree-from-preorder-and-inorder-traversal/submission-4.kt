/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        var p = 0
        var i = 0

        fun dfs(
            limit: Int
        ): TreeNode? {
            if (p > preorder.lastIndex) return null

            if (inorder[i] == limit) {
                i++
                return null
            }

            val root = TreeNode(preorder[p])
            p++

            root.left = dfs(root.`val`)
            root.right = dfs(limit)

            return root
        }

        return dfs(Int.MAX_VALUE)
    }

    
}

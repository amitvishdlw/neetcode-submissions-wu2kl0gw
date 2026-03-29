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
        fun rec(
            il: Int, 
            ir: Int
        ): TreeNode? {
            if (p > preorder.lastIndex) return null
            for (i in il..ir) {
                if (inorder[i] == preorder[p]) {
                    val n = TreeNode(preorder[p])
                    p++
                    n?.left = rec(il, i-1)
                    n?.right = rec(i+1,ir)
                    return n
                }
            }
            return null
        }

        return rec(0, inorder.lastIndex)
    }

    
}

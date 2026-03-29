/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        fun rec(
            p: Int, 
            il: Int, 
            ir: Int
        ): TreeNode? {
            if (p > preorder.lastIndex) return null
            for (i in il..ir) {
                if (inorder[i] == preorder[p]) {
                    val n = TreeNode(preorder[p])
                    n?.left = rec(p+1, il, i-1)
                    n?.right = rec(p+i-il+1, i+1,ir)
                    return n
                }
            }
            return null
        }

        return rec(0, 0, inorder.lastIndex)
    }

    
}

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    private val memo = mutableMapOf<Pair<TreeNode, TreeNode?>, Boolean>()
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null && subRoot == null) return true
        if (root == null || subRoot == null) return false
        return isSameTree(root, subRoot) || isSubtree(root?.left, subRoot) || isSubtree(root?.right, subRoot)
    }

    private fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true
        if (p!= null && q!= null && p.`val` == q.`val`) {
            if (memo.containsKey(p to q)) return memo[p to q]!!
            memo[p to q] = isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
            return memo[p to q]!!
        }
        return false
    }
}

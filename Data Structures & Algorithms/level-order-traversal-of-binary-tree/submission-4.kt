/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        root ?: return emptyList()

        var q = ArrayDeque<TreeNode>()
        q.addLast(root)
        return buildList {
            while(!q.isEmpty()) {
                val lvlList = mutableListOf<Int>()
                val qLen = q.size

                for (i in 0..<qLen) {
                    val n = q.removeFirst()
                    lvlList.add(n.`val`)
                    n?.left?.let {
                        q.addLast(it)
                    }
                    n?.right?.let {
                        q.addLast(it)
                    }
                }

                add(lvlList)
            }
        }
    }
}

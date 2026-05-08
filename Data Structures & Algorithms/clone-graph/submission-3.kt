/*
Definition for a Node.
class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}
*/

class Solution {
    fun cloneGraph(node: Node?): Node? {
        node ?: return null

        val visited = HashMap<Node, Node>()
        
        fun dfs(x: Node?): Node? {
            visited[x]?.let { return it }

            val y = Node(x!!.`val`)
            visited[x] = y

            for (xx in x.neighbors) {
                y.neighbors.add(dfs(xx))
            }

            return y
        }

        return dfs(node)
    }
}

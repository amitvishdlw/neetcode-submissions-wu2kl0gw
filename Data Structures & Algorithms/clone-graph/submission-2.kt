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

            x ?: return null
            visited[x] = Node(x.`val`)

            for (y in x.neighbors) {
                visited[x]!!.neighbors.add(dfs(y))
            }

            return visited[x]!!
        }

        return dfs(node)
    }
}

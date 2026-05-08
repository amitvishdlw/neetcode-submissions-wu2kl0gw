/*
Definition for a Node.
class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}
*/

class Solution {
    val register = mutableMapOf<Node, Node>()
    fun cloneGraph(node: Node?): Node? {
        register.clear()
        return cloneGraphInternal(node)
    }

    fun cloneGraphInternal(node: Node?): Node? {
        node ?: return null
        if (node.neighbors.isEmpty()) return Node(node.`val`)
        val newNode = Node(node.`val`)
        register[node] = newNode
        node.neighbors.forEach {
            if (it != null && !register.contains(it)) {
                newNode.neighbors.add(cloneGraphInternal(it))
            } else if (it != null) {
                newNode.neighbors.add(register[it])
            }
        }
        return newNode
    } 
}

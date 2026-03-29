class PrefixTree {
    private val root = Node()

    fun insert(word: String) {
        var cur = root
        word.forEachIndexed { idx, ch ->
            var found = false
            for (child in cur.childs) {
                if (child.char == ch) {
                    found = true
                    cur = child
                    break
                }
            }

            if (!found) {
                val newNode = Node(
                    char = ch
                )
                cur.childs.add(newNode)
                cur = cur.childs.last()
            }
        }
        cur.isTerminalNode = true
    }

    fun search(word: String): Boolean {
        var cur = root
        word.forEachIndexed { idx, ch ->
            var found = false
            for (child in cur.childs) {
                if (child.char == ch) {
                    found = true
                    cur = child
                    break
                }
            }
            if (!found) return false
        }
        return cur.isTerminalNode
    }

    fun startsWith(prefix: String): Boolean {
        var cur = root
        prefix.forEachIndexed { idx, ch ->
            var found = false
            for (child in cur.childs) {
                if (child.char == ch) {
                    found = true
                    cur = child
                    break
                }
            }
            if (!found) return false
        }
        return true
    }

    private data class Node(
        val char: Char? = null,
        var isTerminalNode: Boolean = false,
        val childs: MutableList<Node> = mutableListOf<Node>(),
    )
}

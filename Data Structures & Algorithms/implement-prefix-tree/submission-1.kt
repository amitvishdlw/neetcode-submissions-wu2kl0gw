class PrefixTree {
    private val root = Node()

    fun insert(word: String) {
        var cur = root
        word.forEachIndexed { idx, ch ->
            if (ch !in cur.childs) {
                cur.childs[ch] = Node()
            }
            cur = cur.childs[ch]!!
        }
        cur.isTerminalNode = true
    }

    fun search(word: String): Boolean {
        var cur = root
        word.forEach { ch ->
            if (ch !in cur.childs) {
                return false
            }
            cur = cur.childs[ch]!!
        }
        return cur.isTerminalNode
    }

    fun startsWith(prefix: String): Boolean {
        var cur = root
        prefix.forEach { ch ->
            if (ch !in cur.childs) {
                return false
            }
            cur = cur.childs[ch]!!
        }
        return true
    }

    private data class Node(
        val childs: HashMap<Char, Node> = HashMap<Char, Node>(),
        var isTerminalNode: Boolean = false,
    )
}

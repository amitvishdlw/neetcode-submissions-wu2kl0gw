class WordDictionary {
    private val root = Node()

    fun addWord(word: String) {
        var cur = root
        word.forEach { ch ->
            if (ch !in cur.childs) {
                cur.childs[ch] = Node()
            }
            cur = cur.childs[ch]!!
        }
        cur.isEnd = true
    }

    fun search(word: String): Boolean {
        var found = false
        fun rec(cur: Node, matchedLen: Int) {
            if (matchedLen == word.length) {
                found = cur.isEnd
                return
            }
            val ch = word[matchedLen]
            if (ch == '.') {
                cur.childs.entries.forEach { (chh, node) ->
                    rec(node, matchedLen + 1)
                }
            } else {
                if (ch in cur.childs) {
                    rec(cur.childs[ch]!!, matchedLen + 1)
                }
            }
        }
        rec(root, 0)
        return found
    }

    private data class Node(
        val childs: HashMap<Char, Node> = HashMap<Char, Node>(),
        var isEnd: Boolean = false
    )
}

class Solution {
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val ds = Trie()
        val n = board.size
        val m = board[0].size
        val ans = mutableSetOf<String>()
        val vis = Array(n) { BooleanArray(m) }
        var maxLen = 0

        for (word in words) {
            maxLen = max(maxLen, word.length)
            ds.add(word)
        }
        
        
        fun dfs(i: Int, j: Int, cur: String) {
            if (cur.length > maxLen) return
            if (ds.find(cur)) {
                ans.add(cur)
            }
            if (i >= 1 && !vis[i-1][j]) {
                vis[i-1][j] = true
                dfs(i-1,j,cur+board[i-1][j])
                vis[i-1][j] = false
            }
            if (j >= 1 && !vis[i][j-1]) {
                vis[i][j-1] = true
                dfs(i,j-1,cur+board[i][j-1])
                vis[i][j-1] = false
            }
            if (i+1<n && !vis[i+1][j]) {
                vis[i+1][j] = true
                dfs(i+1,j,cur+board[i+1][j])
                vis[i+1][j] = false
            }
            if (j+1<m && !vis[i][j+1]) {
                vis[i][j+1] = true
                dfs(i,j+1,cur+board[i][j+1])
                vis[i][j+1] = false
            }
        }

        for (i in board.indices) {
            for (j in board[i].indices) {
                vis[i][j] = true
                dfs(i, j,board[i][j].toString())
                vis[i][j] = false
            }
        }
        return ans.toList()
    }
}

class Trie {
    private val root = Node()

    fun add(word: String) {
        var cur = root
        for (c in word) {
            if (c !in cur.childs) {
                cur.childs[c] = Node()
            }
            cur = cur.childs[c]!!
        }
        cur.isEnd = true
    }

    fun find(word: String): Boolean {
        var cur = root
        for (c in word) {
            if (c !in cur.childs) {
                return false
            }
            cur = cur.childs[c]!!
        }
        return cur.isEnd
    }

    data class Node(
        val childs: HashMap<Char, Node> = HashMap<Char, Node>(),
        var isEnd: Boolean = false
    )
}

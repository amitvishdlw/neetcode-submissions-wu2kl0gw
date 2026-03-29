class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val n = board.size
        val m = board[0].size
        val vis = Array(n) { BooleanArray(m) }
        var found = false

        fun dfs(i: Int, j: Int, matchedLen: Int) {
            if (i < 0 || j < 0 || i >= n || j >= m) return

            if (matchedLen == word.length) {
                found = true
                return 
            }

            val curChar = word[matchedLen]

            if (i+1 < n && !vis[i+1][j] && curChar == board[i+1][j]) {
                vis[i+1][j] = true
                dfs(i+1, j, matchedLen + 1)
                vis[i+1][j] = false
            }
            if (j+1 < m && !vis[i][j+1] && curChar == board[i][j+1]) {
                vis[i][j+1] = true
                dfs(i, j+1, matchedLen + 1)
                vis[i][j+1] = false
            }
            if (i >= 1 && !vis[i-1][j] && curChar == board[i-1][j]) {
                vis[i-1][j] = true
                dfs(i-1, j, matchedLen + 1)
                vis[i-1][j] = false
            }
            if (j >= 1 && !vis[i][j-1] && curChar == board[i][j-1]) {
                vis[i][j-1] = true
                dfs(i, j-1, matchedLen + 1)
                vis[i][j-1] = false
            }
        }

        for (i in board.indices) {
            for (j in board[i].indices) {
                if (board[i][j] == word[0]) {
                    vis[i][j] = true
                    dfs(i, j, 1)
                    vis[i][j] = false
                }
            }
        }

        return found
    }
}

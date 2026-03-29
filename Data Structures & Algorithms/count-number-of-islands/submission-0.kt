class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val n = grid.size
        val m = grid[0].size
        val vis = Array(n) { BooleanArray(m) }
        val dir = listOf<IntArray>(
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(-1, 0)
        )
        var ans = 0

        fun isSafe(i: Int, j: Int): Boolean {
            return !(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == '0' || vis[i][j])
        }

        fun dfs(i: Int, j: Int) {
            vis[i][j] = true
            for (d in dir) {
                val ni = i + d[0]
                val nj = j + d[1]
                if (isSafe(ni, nj)) {
                    dfs(ni, nj)
                }
            }
        }

        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    ans++
                    dfs(i, j)
                }
            }
        }

        return ans
    }
}

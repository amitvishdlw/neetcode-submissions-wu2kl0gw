class Solution {
    private val DIR = listOf<Int>(
        0, // right 
        1, // down
        2, // left
        3, // up
    )
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val n = matrix.size
        val m = matrix[0].size
        val list = mutableListOf<Int>()
        val vis = Array(n) { IntArray(m) }
        
        fun rec(i: Int, j: Int, dir: Int) {
            if (i < 0 || i >= n || j < 0 || j >= m) return
            if (vis[i][j] == -1) return
            vis[i][j] = -1
            list.add(matrix[i][j])

            when (dir) {
                0 -> if (j + 1 < m && vis[i][j+1] == 0) {
                        rec(i, j+1, 0)
                    } else rec(i+1, j, 1)

                1 -> if (i + 1 < n && vis[i+1][j] == 0) {
                        rec(i+1, j, 1) 
                    } else rec(i, j-1, 2)

                2 -> if (j >= 1 && vis[i][j-1] == 0) {
                        rec(i, j-1, 2) 
                    } else rec(i-1, j, 3)
                3 -> if (i >= 1 && vis[i-1][j] == 0) {
                        rec(i-1, j, 3) 
                        } else rec(i, j+1, 0)
                else -> Unit
            }
        }
        rec(0, 0, 0)

        return list
    }
}

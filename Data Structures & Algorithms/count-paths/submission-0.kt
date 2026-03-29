class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val dp = Array(m) { IntArray(n) }
        dp[m-1][n-1] = 1
        for (i in m-1 downTo 0) {
            for (j in n-1 downTo 0) {
                if (i+1<m)
                dp[i][j] += dp[i+1][j]

                if (j+1<n)
                dp[i][j] += dp[i][j+1]
            }
        }
        return dp[0][0]
    }
}

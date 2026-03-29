class Solution {
    fun longestCommonSubsequence(a: String, b: String): Int {
        val dp = Array(a.length) { IntArray(b.length) {-1} }
        fun rec(i: Int, j: Int): Int {
            if (i == a.length || j == b.length) return 0
            if (dp[i][j] != -1) return dp[i][j]
            dp[i][j] = maxOf((if (a[i] == b[j]) 1 else 0) + rec(i+1,j+1), rec(i+1,j), rec(i,j+1))
            return dp[i][j]
        }
        return rec(0,0)
    }
}

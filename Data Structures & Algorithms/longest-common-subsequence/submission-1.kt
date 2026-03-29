class Solution {
    fun longestCommonSubsequence(a: String, b: String): Int {
        val dp = Array(a.length+1) { IntArray(b.length+1) {0} }
        for (i in a.length-1 downTo 0) {
            for (j in b.length-1 downTo 0) {
                dp[i][j] = maxOf((if (a[i]==b[j]) 1 else 0) + dp[i+1][j+1], dp[i+1][j], dp[i][j+1])
            }
        }
        return dp[0][0]
    }
}

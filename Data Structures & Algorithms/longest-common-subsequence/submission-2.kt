class Solution {
    fun longestCommonSubsequence(a: String, b: String): Int {
        var dp = IntArray(b.length+1) {0} 
        for (i in a.length-1 downTo 0) {
            val newDp = IntArray(b.length+1) {0}
            for (j in b.length-1 downTo 0) {
                newDp[j] = maxOf((if (a[i]==b[j]) 1 else 0) + dp[j+1], dp[j], newDp[j+1])
            }
            dp = newDp
        }
        return dp[0]
    }
}

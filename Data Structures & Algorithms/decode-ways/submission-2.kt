class Solution {
    fun numDecodings(s: String): Int {
        if (s.isEmpty()) return 0
        val dp = Array<Int?>(s.length) { null }
        fun solve(i: Int): Int {
            if (i >= s.length) return 1
            if (dp[i] != null) return dp[i]!!
            val takeOne = if (i in s.indices && s[i] in '1'..'9') {
                solve(i + 1)
            } else 0
            val takeTwo = if (
                i in s.indices && (i+1) in s.indices &&
                ((s[i] == '1' && s[i + 1] in '0'..'9') ||
                (s[i] == '2' && s[i + 1] in '0'..'6'))
            ) {
                solve(i + 2)
            } else 0
            dp[i] = takeOne + takeTwo
            return dp[i]!!
        }
        return solve(0)
    }
}

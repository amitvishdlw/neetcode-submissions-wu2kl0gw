class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val dp = Array<Boolean?>(s.length + 1) { null }
        fun solve(i: Int): Boolean {
            if (i >= s.length) return true
            if (dp[i] != null) return dp[i]!!
            for (word in wordDict) {
                if (word.length > s.lastIndex - i + 1) continue
                val subString = s.substring(i, i + word.length)
                if (word == subString) {
                    dp[i] = (dp[i] ?: false) || solve(i+word.length)
                }
            }
            return dp[i] ?: false
        }
        return solve(0)
    }
}
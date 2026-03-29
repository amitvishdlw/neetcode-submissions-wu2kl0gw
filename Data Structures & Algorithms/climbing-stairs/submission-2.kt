class Solution {
    fun climbStairs(n: Int): Int {
        val dp = IntArray(3)
        dp[0] = 1
        dp[1] = 1
        
        for (i in 2..n) {
            dp[i%3] = dp[(i-1)%3] + dp[(i-2)%3]
        }
        return dp[n%3]
    }
}

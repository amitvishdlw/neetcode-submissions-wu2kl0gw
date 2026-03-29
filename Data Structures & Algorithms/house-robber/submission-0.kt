class Solution {
    // dp[i][f] = max money collected if f = 1, current house robbed, else not
    fun rob(nums: IntArray): Int {
        val n = nums.size
        val dp = Array<IntArray>(n+1) { IntArray(2) }

        dp[1][0] = 0
        dp[1][1] = nums[0]

        for (i in 2..n) {
            dp[i][0] = max(dp[i][0], max(dp[i-1][0], dp[i-1][1]))
            dp[i][1] = max(dp[i][1], nums[i-1] + dp[i-1][0])
        } 

        return max(dp[n][0],dp[n][1])
    }
}

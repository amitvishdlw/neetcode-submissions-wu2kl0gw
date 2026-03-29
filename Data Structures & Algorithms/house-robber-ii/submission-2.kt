class Solution {
    fun rob(nums: IntArray): Int {
        val n = nums.size
        if (n == 1) return nums[0]

        fun rec(i: Int, end: Int, dp: IntArray): Int {
            if (i >= end) return 0
            if (dp[i] != -1) return dp[i]
            dp[i] = max(rec(i+1,end,dp), rec(i+2,end,dp) + nums[i])
            return dp[i]
        }

        return max(rec(0,n-1, IntArray(n) {-1}), rec(1,n,IntArray(n){-1}))
    }
}
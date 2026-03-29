class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        if (amount < 0) return -1
        coins.sortDescending()

        val dp = IntArray(amount+1) { Int.MAX_VALUE }
        dp[0] = 0
        for (i in 0 until coins.size) {
            if (coins[i] <= amount)
            dp[coins[i]] = 1
        }

        for (sum in 1..amount) {
            for (i in 0 until coins.size) {
                if (sum >= coins[i] && dp[sum - coins[i]] != Int.MAX_VALUE) {
                    dp[sum] = minOf(dp[sum], 1 + dp[sum - coins[i]])
                } 
            }
        }

        return if (dp[amount] == Int.MAX_VALUE) -1 else dp[amount]
    }
}
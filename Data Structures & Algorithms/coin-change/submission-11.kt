class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = Array<Int?>(amount + 1) { null }
        dp[0] = 0
        for (coin in coins) {
            if (coin <= amount) {
                dp[coin] = 1
            }
        }

        for (amt in (1..amount)) {
            for (coin in coins) {
                if (coin > amt) continue
                dp[amt - coin] ?: continue
            
                dp[amt] = minOf(dp[amt] ?: Int.MAX_VALUE, 1 + dp[amt - coin]!!)
            }
        }

        return dp[amount] ?: -1
    }
}
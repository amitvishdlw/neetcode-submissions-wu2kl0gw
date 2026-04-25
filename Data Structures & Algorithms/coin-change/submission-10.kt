class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1) { -1 }
        dp[0] = 0
        for (coin in coins) {
            if (coin <= amount) {
                dp[coin] = 1
            }
        }

        for (amt in (1..amount)) {
            for (coin in coins) {
                if (coin > amt) continue

                dp[amt] = when {
                    dp[amt] == -1 && dp[amt - coin] != -1 -> {
                        1 + dp[amt - coin]
                    } 
                    dp[amt] != -1 && dp[amt - coin] != -1 -> {
                        minOf(dp[amt], 1 + dp[amt - coin])
                    }
                    else -> dp[amt]
                }
            }
        }

        return dp[amount]
    }
}
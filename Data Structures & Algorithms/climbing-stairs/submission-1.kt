class Solution {
    private val N = 46
    private val memo = IntArray(46) { -1 }

    fun climbStairs(n: Int): Int {
        if (n < 0) return 0
        if (n == 0) return 1
        if (memo[n] != -1) return memo[n]
        memo[n] = climbStairs(n-1) + climbStairs(n-2)
        return memo[n]
    }
}

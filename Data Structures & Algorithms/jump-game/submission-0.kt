class Solution {
    fun canJump(nums: IntArray): Boolean {
        val memo = Array(nums.size + 1) { -1 }
        fun dfs(i: Int): Boolean {
            if (i >= nums.size) return true
            if (memo[i] != -1) return memo[i] == 1
            val jump = nums[i-1]
            var pos = false
            for (j in i+1..(i+jump)) {
                pos = pos or dfs(j)
            }
            memo[i] = if (pos) 1 else 0
            return pos
        }
        return dfs(1)
    }
}

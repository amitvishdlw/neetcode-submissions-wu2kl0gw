class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val numSet = nums.toSet()
        var res = 0
        for (num in numSet) {
            if ((num - 1) !in numSet) {
                var streak = 0
                var cur = num
                while (cur in numSet) {
                    cur += 1
                    streak += 1
                }
                res = max(res, streak)
            }
        }
        return res
    }
}
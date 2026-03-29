class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var maxSum = nums[0]
        var curSum = 0
        nums.forEach {
            curSum += it
            maxSum = max(maxSum, curSum)
            if (curSum < 0) curSum = 0
        }
        return maxSum
    }
}

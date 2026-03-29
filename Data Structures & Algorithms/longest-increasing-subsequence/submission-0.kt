class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val lis = IntArray(nums.size) {1}
        for (i in nums.size-1 downTo 0) {
            for (j in i+1 until nums.size) {
                if (nums[j] > nums[i]) {
                    lis[i] = maxOf(lis[i], 1 + lis[j])
                }
            }
        }
        return lis.maxOrNull() ?: 0
    }
}